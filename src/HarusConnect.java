import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class HarusConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksiSaya = new ConnectURI();

        URL myAddress = koneksiSaya.buildURL
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksiSaya.getresponsefromhttpUrl(myAddress);
        System.out.println(response);
        assert response !=null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<Model> models = new ArrayList<>();
        for(int i=0;i<responseJSON.length();i++){
            Model model = new Model();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            model.setIname(myJSONObject.getString("i_name"));
            model.setIqty(myJSONObject.getString("i_qty"));
            model.setIsell(myJSONObject.getString("i_sell"));

            models.add(model);
        }
        System.out.println("Response are");
        for (int index=0;index<models.size();index++){
            System.out.println("INAME : " + models.get(index).getIname());
            System.out.println("IQTY : " + models.get(index).getIqty());
            System.out.println("ISELL : " + models.get(index).getIsell());
        }

    }
}

