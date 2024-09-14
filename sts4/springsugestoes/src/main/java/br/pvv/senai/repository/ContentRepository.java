package br.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.models.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}
