package task_b_03;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LogParser {

    static class Tag {
        private String name;
        private Map<String, String> attr = new HashMap<>();
        private List<Tag> childs = new LinkedList<>();
        private String value;

        public Tag(String name, Map<String, String> attr, List<Tag> childs, String value) {
            this.name = name;
            this.attr = attr;
            this.childs = childs;
            this.value = value;
        }

        public Tag(String name) {
            this.name = name;
        }

        public Tag() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Map<String, String> getAttr() {
            return attr;
        }

        public void setAttr(Map<String, String> attr) {
            this.attr = attr;
        }

        public List<Tag> getChilds() {
            return childs;
        }

        public void setChilds(List<Tag> childs) {
            this.childs = childs;
        }
    }

    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        parseXml(xml);

        return Collections.EMPTY_LIST;
    }

    private static Tag parseXml(String xml) {
        Queue<Tag> fifo = new LinkedList<>();
        int cursor = 0;

        while(cursor < xml.length()) {

            Tag currentTag = new Tag();
            cursor = xml.indexOf("<", cursor) ; // tag start found
            if (xml.charAt(cursor+1) != '?') { // not xml title

                if (xml.charAt(cursor+1) != '/') { // opening tag

                    // todo check for self closed tag
                    String tagName;
                    String tagNameCandidate1 = xml.substring(cursor+1, xml.indexOf(' ',cursor+1));
                    String tagNameCandidate2 = xml.substring(cursor+1, xml.indexOf('>',cursor+1));

                    // have attr?
                    if (tagNameCandidate1.length() > tagNameCandidate2.length()) { // no attr
                        tagName = tagNameCandidate2;
                        cursor = cursor + tagName.length();
                        currentTag.setName(tagName);

                        System.out.println(tagName + " --- " + cursor);
                    } else { // there are attrs, lets parse
                        tagName = tagNameCandidate1;
                        cursor = cursor + tagName.length();
                        currentTag.setName(tagName);
                        String attrs = xml.substring(cursor+1, xml.indexOf('>',cursor) ).trim();
                        System.out.println(tagName + " --- " + cursor + " --- " + attrs);
                        String[] parts = attrs.split("=");
                        System.out.println("attr " + parts[0] + "val " + parts[1]) ;
                        Map<String, String> attrss = new HashMap<>();
                        attrss.put(parts[0], parts[1].replace("\"", ""));
                        currentTag.setAttr(attrss);

                    }
                    cursor = cursor + tagName.length();
                    fifo.add(currentTag);

                } else { // closing tag

                }



            } else { // skip xml title tag
                cursor = xml.indexOf("?>", cursor) + 2;
            }

        }



        return new Tag();

    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println(id);
    }

}
