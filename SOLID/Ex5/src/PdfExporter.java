import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    private final Formatter formatter;
	

    public PdfExporter(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String pdf = formatter.format(req);

        return new ExportResult(
                "application/pdf",
                pdf.getBytes(StandardCharsets.UTF_8)
        );
    }
}