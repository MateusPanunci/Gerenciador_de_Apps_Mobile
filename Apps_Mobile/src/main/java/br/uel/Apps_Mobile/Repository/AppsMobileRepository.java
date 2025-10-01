package br.uel.Apps_Mobile.Repository;

import br.uel.Apps_Mobile.Model.AppMobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppsMobileRepository extends JpaRepository<AppMobile, Long> {
    Optional<AppMobile> findByNome(String nome);
}
