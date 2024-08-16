package com.project.project.proyek;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proyek_lokasi")
public class ProyekLokasi {
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private Integer proyek_id;
	
	public ProyekLokasi(){
		   super();
	}

	public ProyekLokasi(Integer proyek_id) {
		super();
		this.proyek_id = proyek_id;
	}

	@Override
	public String toString() {
		return "ProyekLokasi [proyek_id=" + proyek_id + "]";
	}

	public Integer getProyek_id() {
		return proyek_id;
	}

	public void setProyek_id(Integer proyek_id) {
		this.proyek_id = proyek_id;
	}
}
