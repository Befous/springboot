package com.project.project.proyek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.project.project.lokasi.Lokasi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="proyek")
public class Proyek {
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	
	private Integer id;
	private String nama_proyek;
	private String client;
	private LocalDate tgl_mulai;
	private LocalDate tgl_selesai;
	private String pimpinan_proyek;
	private String keterangan;
	@Column(name = "created_at", updatable = false)
	private LocalDateTime created_at;
	@PrePersist
    protected void onCreate() {
		created_at = LocalDateTime.now();
    }
	
	@ManyToMany
	@JoinTable(
			name = "proyek_lokasi",
			joinColumns = @JoinColumn(name = "proyek_id"),
			inverseJoinColumns = @JoinColumn(name = "lokasi_id")
	)
	private Set<Lokasi> lokasiProyek = new HashSet<>();
	
	public Set<Lokasi> getLokasiProyek() {
		return lokasiProyek;
	}

	public void setLokasiProyek(Set<Lokasi> lokasiProyek) {
		this.lokasiProyek = lokasiProyek;
	}

	public Proyek() {
		super();
	}
	
	public Proyek(Integer id, String nama_proyek, String client, LocalDate tgl_mulai, LocalDate tgl_selesai,
			String pimpinan_proyek, String keterangan, LocalDateTime created_at, Integer lokasi_id) {
		super();
		this.id = id;
		this.nama_proyek = nama_proyek;
		this.client = client;
		this.tgl_mulai = tgl_mulai;
		this.tgl_selesai = tgl_selesai;
		this.pimpinan_proyek = pimpinan_proyek;
		this.keterangan = keterangan;
		this.created_at = created_at;
	}
	
	public Proyek(String nama_proyek, String client, LocalDate tgl_mulai, LocalDate tgl_selesai, String pimpinan_proyek,
			String keterangan, LocalDateTime created_at) {
		super();
		this.nama_proyek = nama_proyek;
		this.client = client;
		this.tgl_mulai = tgl_mulai;
		this.tgl_selesai = tgl_selesai;
		this.pimpinan_proyek = pimpinan_proyek;
		this.keterangan = keterangan;
		this.created_at = created_at;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_proyek() {
		return nama_proyek;
	}
	public void setNama_proyek(String nama_proyek) {
		this.nama_proyek = nama_proyek;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public LocalDate getTgl_mulai() {
		return tgl_mulai;
	}
	public void setTgl_mulai(LocalDate tgl_mulai) {
		this.tgl_mulai = tgl_mulai;
	}
	public LocalDate getTgl_selesai() {
		return tgl_selesai;
	}
	public void setTgl_selesai(LocalDate tgl_selesai) {
		this.tgl_selesai = tgl_selesai;
	}
	public String getPimpinan_proyek() {
		return pimpinan_proyek;
	}
	public void setPimpinan_proyek(String pimpinan_proyek) {
		this.pimpinan_proyek = pimpinan_proyek;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Proyek [id=" + id + ", nama_proyek=" + nama_proyek + ", client=" + client + ", tgl_mulai=" + tgl_mulai
				+ ", tgl_selesai=" + tgl_selesai + ", pimpinan_proyek=" + pimpinan_proyek + ", keterangan=" + keterangan
				+ ", created_at=" + created_at + "]";
	}
}
