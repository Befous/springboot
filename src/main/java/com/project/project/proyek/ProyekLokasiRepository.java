package com.project.project.proyek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository 
	extends JpaRepository<ProyekLokasi, Integer> {
}