package com.project.project.lokasi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository
	extends JpaRepository<Lokasi, Integer> {
}