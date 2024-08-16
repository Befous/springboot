package com.project.project.proyek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "api/proyek")
public class ProyekController {
	private final ProyekService proyekService;
	
	@Autowired
	public ProyekController(ProyekService proyekService) {
		super();
		this.proyekService = proyekService;
	}
	@GetMapping
	public List<Proyek> getProyek() {
		return proyekService.getProyek();
	}
	@PostMapping
	public void tambahProyek(@RequestBody Proyek proyek) {
		proyekService.addNewProyek(proyek);
	}
	@DeleteMapping(path = "{proyekId}")
	public void hapusProyek(@PathVariable("proyekId") Integer proyekId) {
		proyekService.deleteProyek(proyekId);
	}
	@PutMapping(path = "{proyekId}")
	public void editProyek(
			@PathVariable("proyekId") Integer proyekId,
			@RequestParam(required = false) String nama_proyek,
			@RequestParam(required = false) String client,
			@RequestParam(required = false) LocalDate tgl_mulai,
			@RequestParam(required = false) LocalDate tgl_selesai,
			@RequestParam(required = false) String pimpinan_proyek,
			@RequestParam(required = false) String keterangan) {
		proyekService.updateProyek(proyekId, nama_proyek, client, tgl_mulai, tgl_selesai, pimpinan_proyek, keterangan);
	}
	@PutMapping(path = "{proyekId}/lokasi/{lokasiId}")
	public void menetapkanProyekLokasi(
			@PathVariable Integer proyekId,
			@PathVariable Integer lokasiId) {
		proyekService.assignProyekLokasi(proyekId, lokasiId);
	}
}
