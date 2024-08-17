package com.project.project.proyek;
import java.time.LocalDate;
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
@RequestMapping(path = "api/proyek")
public class ProyekController {
	private final ProyekService proyekService;
	
	@Autowired
	public ProyekController(ProyekService proyekService) {
		super();
		this.proyekService = proyekService;
	}
	@CrossOrigin
	@GetMapping
	public List<Proyek> getProyek() {
		return proyekService.getProyek();
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> tambahProyek(@RequestBody Proyek proyek) {
		try {
		      Response response = proyekService.addNewProyek(proyek);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@CrossOrigin
	@DeleteMapping(path = "{proyekId}")
	public ResponseEntity<?> hapusProyek(@PathVariable("proyekId") Integer proyekId) {
		try {
		      Response response = proyekService.deleteProyek(proyekId);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@CrossOrigin
	@PutMapping(path = "{proyekId}")
	public ResponseEntity<?> editProyek(
			@PathVariable("proyekId") Integer proyekId,
			@RequestParam(required = false) String nama_proyek,
			@RequestParam(required = false) String client,
			@RequestParam(required = false) LocalDate tgl_mulai,
			@RequestParam(required = false) LocalDate tgl_selesai,
			@RequestParam(required = false) String pimpinan_proyek,
			@RequestParam(required = false) String keterangan) {
		try {
		      Response response = proyekService.updateProyek(proyekId, nama_proyek, client, tgl_mulai, tgl_selesai, pimpinan_proyek, keterangan);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	@CrossOrigin
	@PutMapping(path = "{proyekId}/lokasi/{lokasiId}")
	public ResponseEntity<?> menetapkanProyekLokasi(
			@PathVariable Integer proyekId,
			@PathVariable Integer lokasiId) {
		try {
		      Response response = proyekService.assignProyekLokasi(proyekId, lokasiId);
		      return ResponseEntity.status(response.getStatus()).body(response);
		} catch (Exception e) {
		      return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
