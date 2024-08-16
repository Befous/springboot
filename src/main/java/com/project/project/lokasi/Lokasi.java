package com.project.project.lokasi;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.project.proyek.Proyek;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Data
public class Lokasi {
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	
	private Integer id;
	private String nama_lokasi;
	private String negara;
	private String provinsi;
	private String kota;
	@Column(name = "created_at", updatable = false)
	private LocalDateTime created_at;
	@PrePersist
    protected void onCreate() {
		created_at = LocalDateTime.now();
    }
	
	@JsonIgnore
	@ManyToMany(mappedBy = "lokasiProyek")
	private Set<Proyek> proyekkk = new HashSet<>();
	
	public Set<Proyek> getProyekkk() {
		return proyekkk;
	}

	public void setProyekkk(Set<Proyek> proyekkk) {
		this.proyekkk = proyekkk;
	}

	public Lokasi() {
		super();
	}
	
	public Lokasi(Integer id, String nama_lokasi, String negara, String provinsi, String kota,
			LocalDateTime created_at) {
		super();
		this.id = id;
		this.nama_lokasi = nama_lokasi;
		this.negara = negara;
		this.provinsi = provinsi;
		this.kota = kota;
		this.created_at = created_at;
	}
	
	public Lokasi(String nama_lokasi, String negara, String provinsi, String kota, LocalDateTime created_at) {
		super();
		this.nama_lokasi = nama_lokasi;
		this.negara = negara;
		this.provinsi = provinsi;
		this.kota = kota;
		this.created_at = created_at;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_lokasi() {
		return nama_lokasi;
	}
	public void setNama_lokasi(String nama_lokasi) {
		this.nama_lokasi = nama_lokasi;
	}
	public String getNegara() {
		return negara;
	}
	public void setNegara(String negara) {
		this.negara = negara;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	@Override
	public String toString() {
		return "Lokasi [id=" + id + ", nama_lokasi=" + nama_lokasi + ", negara=" + negara + ", provinsi=" + provinsi
				+ ", kota=" + kota + ", created_at=" + created_at + "]";
	}
}
