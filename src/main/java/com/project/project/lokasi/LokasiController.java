package com.project.project.lokasi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/lokasi")
public class LokasiController {
	private final LokasiService lokasiService;
	
	@Autowired
	public LokasiController(LokasiService lokasiService) {
		super();
		this.lokasiService = lokasiService;
	}
	@CrossOrigin
	@GetMapping
	public List<Lokasi> getLokasi() {
		return lokasiService.getLokasi();
	}
	@CrossOrigin
	@PostMapping
	public void tambahLokasi(@RequestBody Lokasi lokasi) {
		lokasiService.addNewLokasi(lokasi);
	}
	@CrossOrigin
	@DeleteMapping(path = "{lokasiId}")
	public void hapusLokasi(@PathVariable("lokasiId") Integer lokasiId) {
		lokasiService.deleteLokasi(lokasiId);
	}
	@CrossOrigin
	@PutMapping(path = "{lokasiId}")
	public void editLokasi(
			@PathVariable("lokasiId") Integer lokasiId,
			@RequestParam(required = false) String nama_lokasi,
			@RequestParam(required = false) String negara,
			@RequestParam(required = false) String provinsi,
			@RequestParam(required = false) String kota) {
		lokasiService.updateLokasi(lokasiId, nama_lokasi, negara, provinsi, kota);
	}
}
