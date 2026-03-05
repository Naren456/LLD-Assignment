public class JsonFormatter implements Formatter {

    @Override
    public String format(ExportRequest req) {

        String json =
                "{\"title\":\"" + escape(req.title) +
                "\",\"body\":\"" + escape(req.body) + "\"}";

        return json;
    }

    private String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}