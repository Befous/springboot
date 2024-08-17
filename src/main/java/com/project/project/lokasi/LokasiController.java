package com.project.project.lokasi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.project.project.response.Response;

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
	public ResponseEntity<?> tambahLokasi(@RequestBody Lokasi lokasi) {
		try {
		      Response response = lokasiService.addNewLokasi(lokasi);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@CrossOrigin
	@DeleteMapping(path = "{lokasiId}")
	public ResponseEntity<?> hapusLokasi(@PathVariable("lokasiId") Integer lokasiId) {
		try {
		      Response response = lokasiService.deleteLokasi(lokasiId);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@CrossOrigin
	@PutMapping(path = "{lokasiId}")
	public ResponseEntity<?> editLokasi(
			@PathVariable("lokasiId") Integer lokasiId,
			@RequestParam(required = false) String nama_lokasi,
			@RequestParam(required = false) String negara,
			@RequestParam(required = false) String provinsi,
			@RequestParam(required = false) String kota) {
		try {
		      Response response = lokasiService.updateLokasi(lokasiId, nama_lokasi, negara, provinsi, kota);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
