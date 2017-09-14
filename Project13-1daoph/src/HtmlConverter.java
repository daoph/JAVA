
public class HtmlConverter {

	public static void main(String[] args) {
		
		String html = "<h1>Grocery List</h1>\n" +
	              "<ul>\n" +
	              "    <li>Eggs</li>\n" +
	              "    <li>Milk</li>\n" +
	              "    <li>Butter</li>\n" +
	              "</ul>";
		System.out.println(html);
		System.out.println();
		
		html = html.replaceAll("<h1>","");
		html = html.replaceAll("</h1>\n","");
		html = html.replaceAll("<ul>","");
		html = html.replaceAll("</ul>","");
		html = html.replaceAll("<li>","*");
		html = html.replaceAll("</li>","");
		
		
		
		System.out.println(html);

	}

}
