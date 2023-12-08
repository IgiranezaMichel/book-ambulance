package com.bookambulance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookambulance.Model.Location;
public interface LocationRepository extends JpaRepository<Location,Long>{

}
