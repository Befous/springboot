package com.project.project.proyek;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project.lokasi.Lokasi;
import com.project.project.lokasi.LokasiRepository;

import jakarta.transaction.Transactional;

@Service
public class ProyekService {
	
	private ProyekRepository proyekRepository;
	private ProyekLokasiRepository proyekLokasiRepository;
	
	@Autowired
	private LokasiRepository lokasiRepository;
	public ProyekService(ProyekRepository proyekRepository, ProyekLokasiRepository proyekLokasiRepository) {
		super();
		this.proyekRepository = proyekRepository;
		this.proyekLokasiRepository = proyekLokasiRepository;
	}

	public List<Proyek> getProyek() {
		return proyekRepository.findAll();
	}

	public void addNewProyek(Proyek proyek) {
		proyekRepository.save(proyek);
	}

	public void deleteProyek(Integer proyekId) {
		boolean exists = proyekRepository.existsById(proyekId);
		
		if (!exists) {
			throw new IllegalStateException(
					"id tidak ditemukan");
		}
		proyekRepository.deleteById(proyekId);
	}

	@Transactional
	public void updateProyek(Integer proyekId, String nama_proyek, String client, LocalDate tgl_mulai,
			LocalDate tgl_selesai, String pimpinan_proyek, String keterangan) {
		Proyek proyek = proyekRepository.findById(proyekId)
				.orElseThrow(() -> new IllegalStateException(
						"id tidak ditemukan"));
		
		if (nama_proyek != null &&
				nama_proyek.length() > 0 &&
				!Objects.equals(proyek.getNama_proyek(), nama_proyek)) {
			proyek.setNama_proyek(nama_proyek);
		}
		
		if (client != null &&
				client.length() > 0 &&
				!Objects.equals(proyek.getClient(), client)) {
			proyek.setClient(client);
		}
		
		if (tgl_mulai != null &&
				!Objects.equals(proyek.getTgl_mulai(), tgl_mulai)) {
			proyek.setTgl_mulai(tgl_mulai);
		}
		
		if (tgl_selesai != null &&
				!Objects.equals(proyek.getTgl_selesai(), tgl_selesai)) {
			proyek.setTgl_selesai(tgl_selesai);
		}
		
		if (pimpinan_proyek != null &&
				pimpinan_proyek.length() > 0 &&
				!Objects.equals(proyek.getPimpinan_proyek(), pimpinan_proyek)) {
			proyek.setPimpinan_proyek(pimpinan_proyek);
		}
		
		if (keterangan != null &&
				keterangan.length() > 0 &&
				!Objects.equals(proyek.getKeterangan(), keterangan)) {
			proyek.setKeterangan(keterangan);
		}
	}

	public void assignProyekLokasi(Integer proyekId, Integer lokasiId) {
		proyekLokasiRepository.deleteById(proyekId);
		Set<Lokasi> lokasiSet = null;
		Proyek proyek = proyekRepository.findById(proyekId).get();
		Lokasi lokasi = lokasiRepository.findById(lokasiId).get();
		lokasiSet = proyek.getLokasiProyek();
		lokasiSet.add(lokasi);
		proyek.setLokasiProyek(lokasiSet);
		proyekRepository.save(proyek);
	}
}
