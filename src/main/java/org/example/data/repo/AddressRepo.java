package org.example.data.repo;

import org.example.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,  Long> {
}
