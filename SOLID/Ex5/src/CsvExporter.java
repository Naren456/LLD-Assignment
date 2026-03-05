import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    private final Formatter formatter;

	

    public CsvExporter(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String csv = formatter.format(req);

        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }
}