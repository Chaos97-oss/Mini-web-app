package com.example.onboarding_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onboarding_web_app.modal.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

}
