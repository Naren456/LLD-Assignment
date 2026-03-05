import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {

    private final Formatter formatter = new JsonFormatter();

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String json = formatter.format(req);

        return new ExportResult(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }
}