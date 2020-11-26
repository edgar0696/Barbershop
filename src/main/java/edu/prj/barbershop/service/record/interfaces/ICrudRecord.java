package edu.prj.barbershop.service.record.interfaces;

import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.model.Record;

import java.util.List;

public interface ICrudRecord {
    Record create(Record record);
    Record get(String id);
    Record update(Record record);
    Record delete(String id);
    List<Record> getAll();

}
