package org.tech4.vackrugerns.ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tech4.vackrugerns.ws.model.UserVaccine;

public interface IUserVaccineDAO extends JpaRepository<UserVaccine, Integer> {

	@Modifying
	@Query(value = "INSERT INTO user_vaccine(id_user, id_vaccine, date_vaccine, num_dosis) VALUES (:idUser, :idVaccine, :dateVaccine, :numDosis)", nativeQuery = true)
	Integer registrar(@Param("idUser") Integer idUser, @Param("idVaccine") Integer idVaccine, 
					  @Param("dateVaccine") String fecVaccine, @Param("numDosis") String numDosis);
	
}
