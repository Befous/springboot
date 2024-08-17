package com.project.project.lokasi;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.project.response.Response;

import jakarta.transaction.Transactional;

@Service
public class LokasiService {
	private final LokasiRepository lokasiRepository;
	
	@Autowired
	public LokasiService(LokasiRepository lokasiRepository) {
		super();
		this.lokasiRepository = lokasiRepository;
	}

	public List<Lokasi> getLokasi() {
		return lokasiRepository.findAll();
	}

	public Response addNewLokasi(Lokasi lokasi) {
		lokasiRepository.save(lokasi);
		// Buat object Response
	    Response response = new Response();
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage("Berhasil menambahkan lokasi baru");
	    response.setData(lokasi);
		return response;
	}

	public Response deleteLokasi(Integer lokasiId) {
		boolean exists = lokasiRepository.existsById(lokasiId);
		
		if (!exists) {
			throw new IllegalStateException(
					"id tidak ditemukan");
		}
		lokasiRepository.deleteById(lokasiId);
		// Buat object Response
	    Response response = new Response();
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage("Berhasil menghapus lokasi");
	    response.setData(null);
		return response;
	}

	@Transactional
	public Response updateLokasi(Integer lokasiId, String nama_lokasi, String negara, String provinsi, String kota) {
		Lokasi lokasi = lokasiRepository.findById(lokasiId)
				.orElseThrow(() -> new IllegalStateException(
						"id tidak ditemukan"));
		
		if (nama_lokasi != null &&
				nama_lokasi.length() > 0 &&
				!Objects.equals(lokasi.getNama_lokasi(), nama_lokasi)) {
			lokasi.setNama_lokasi(nama_lokasi);
		}
		
		if (negara != null &&
				negara.length() > 0 &&
				!Objects.equals(lokasi.getNegara(), negara)) {
			lokasi.setNegara(negara);
		}
		
		if (provinsi != null &&
				provinsi.length() > 0 &&
				!Objects.equals(lokasi.getProvinsi(), provinsi)) {
			lokasi.setProvinsi(provinsi);
		}
		
		if (kota != null &&
				kota.length() > 0 &&
				!Objects.equals(lokasi.getKota(), kota)) {
			lokasi.setKota(kota);
		}
		
		// Buat object Response
	    Response response = new Response();
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage("Berhasil mengedit lokasi");
	    response.setData(null);
		return response;
	}
}
