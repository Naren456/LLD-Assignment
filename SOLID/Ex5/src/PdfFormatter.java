public class PdfFormatter implements Formatter {

    @Override
    public String format(ExportRequest req) {

        if (req.body.length() > 20) {
            throw new IllegalArgumentException(
                    "PDF cannot handle content > 20 chars");
        }

        return "PDF(" + req.title + "):" + req.body;
    }
}