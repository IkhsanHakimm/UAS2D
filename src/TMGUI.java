import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TMGUI extends JFrame {
    private JTextField tfNamabarang;
    private JTextField tfHargabarang;
    private JButton Button;
    private JPanel mainpanel;
    private JTextArea tadaftarbarang;

    public TMGUI(){
        setContentPane(mainpanel);
        setTitle("Daftar Barang");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        TMGUI data = new TMGUI();
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
        data.Button.addActionListener(e -> {
            for (int index = 0; index < models.size(); index++) {
                String nama = String.valueOf(models.get(index).getIname());
                String stok = models.get(index).getIqty();
                int harga = Integer.parseInt(models.get(index).getIsell());

                    if (nama.charAt(0)=='S' && harga<7000 && stok != null){
                        data.tadaftarbarang.append("Nama Barang : " + nama + "\nHarga Barang : Rp " +
                                harga + "\nStok : " + stok + "\n");
                }

            }
        });
    }}