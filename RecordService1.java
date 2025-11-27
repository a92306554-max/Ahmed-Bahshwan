
package recordservice;

import java.util.ArrayList;
import java.util.List;

class RecordService {
    private List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        records.add(record);
    }

    public void updateRecord(int index, Record record) {
        if (index >= 0 && index < records.size()) {
            records.set(index, record);
        }
    }

    public void deleteRecord(int index) {
        if (index >= 0 && index < records.size()) {
            records.remove(index);
        }
    }

    public List<Record> searchRecords(String criteria) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(criteria) || record.getNumber().equalsIgnoreCase(criteria)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<Record> getAllRecords() {
        return records;
    }
}
