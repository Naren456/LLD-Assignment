public class CsvFormatter implements Formatter {

    @Override
    public String format(ExportRequest req) {

        String body = req.body
                .replace("\n", " ")
                .replace(",", " ");

        return "title,body\n" + req.title + "," + body + "\n";
    }
}