//This is a class to test webscraping using jsoup
import java.util.List;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//Scraps OHS website for cats that can be adopted, and outputs the data to stdout in a table format
public class ScrapeCat{

	public static void main(String[] args){


		Document doc;

		try{
			doc = Jsoup.connect("https://www.oregonhumane.org/adopt/?type=cats").get();//download the html from OHS cat adoption and save as a document
			
			//Create sets of each element
			Elements name = doc.select("span.name");//grab name elements
			Elements breed = doc.select("span.breed");//grab breed elements
			Elements sex = doc.select("span.sex");//grab sex elements
			Elements color = doc.select("span.color");//grab color elements
			Elements weight = doc.select("span.weight");//grab weight elements
			Elements age = doc.select("span.age");//grab age elements
			Elements pic = doc.select("img[src*=shelterbuddy]");//grap picutures. the [srt*=shelterbuddy] checks to make sure the URL contains shelterbuddy

			//Create iterators for each attribute. the eachText and eachAttr methods return List<String>, then we convert that to an iterator
			Iterator itName = name.eachText().iterator();
			Iterator itBreed = breed.eachText().iterator();
			Iterator itSex = sex.eachText().iterator();
			Iterator itColor = color.eachText().iterator();
			Iterator itWeight = weight.eachText().iterator();
			Iterator itAge = age.eachText().iterator();
			Iterator itPic = pic.eachAttr("abs:src").iterator();//abs:src grabs the absolute URL instead of relative
			

			for(int i=0;i<name.size();i++){	
				System.out.printf("Weight: %-15s Name:%-15S Age:%-30s <br />Breed:%-20s Sex:%-10s Color:%-20S <br />ImageURL:%s<br /><br />\n",
						itWeight.next(),itName.next(), itAge.next(), itBreed.next(), itSex.next(), itColor.next(), itPic.next());
			}


		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
