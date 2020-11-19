package edu.prj.barbershop.repository;

import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {

}
