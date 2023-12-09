import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CustomButton extends JButton {
    private String graphQLSchemaAdresi;
    private String buttonText;
    private Color aktifRenk;
    private Color pasifRenk;
    private ImageIcon aktifIcon;
    private ImageIcon pasifIcon;
    private boolean aktifDurum;

    public CustomButton(String metin, String schemaAdresi) {
        super(metin);
        this.graphQLSchemaAdresi = schemaAdresi;
        this.buttonText = metin;

        // renk ve simge ayarları
        this.aktifRenk = Color.GREEN;
        this.pasifRenk = Color.RED;
        this.aktifIcon = new ImageIcon("aktif_icon.png");
        this.pasifIcon = new ImageIcon("pasif_icon.png");

        // başlangıç durumu pasif
        setAktifDurum(false);

        // buton tıklama olayı
        addActionListener(new ActionListener() {
            public CustomButton activeButton;

            @Override
            public void actionPerformed(ActionEvent e) {
                handleTiklama(activeButton);
            }
        });

        // Başlangıç görünüm ayarları
        gorunumuGuncelle();
    }

    private void handleTiklama(CustomButton activeButton) {
        // Eğer buton daha önce basıldıysa
        if (aktifDurum) {
            // Tüm butonları pasif hale getir
            tumButonlariPasifYap();
        } else {
            // Eğer bu buton zaten aktifse (daha önce basıldıysa)
            if (activeButton != null && activeButton != this) {
                // Eski aktif butonu pasif yap
                activeButton.setAktifDurum(false);
                activeButton.gorunumuGuncelle();
            }

            // Bu butonu aktif yap
            setAktifDurum(true);

            // GraphQL mutation'ını çalıştır
            executeGraphQLMutation();

            // Görünümü güncelle
            gorunumuGuncelle();

            // Bu butonu şu anki aktif buton olarak belirle
            activeButton = this;
        }
    }

    private void tumButonlariPasifYap() {
        // Tüm butonlara eriş
        Component[] components = getParent().getComponents();
        for (Component component : components) {
            // Eğer component bir CustomButton ise
            if (component instanceof CustomButton) {
                CustomButton button = (CustomButton) component;

                // Butonu pasif hale getir
                button.setAktifDurum(false);

                // Görünümü güncelle
                button.gorunumuGuncelle();
            }
        }

        // Aktif butonu null olarak ayarla (hiçbiri aktif değil)
        Object activeButton = null;
    }


    private void setAktifDurum(boolean aktifDurum) {
        this.aktifDurum = aktifDurum;
    }

    private void gorunumuGuncelle() {
        if (aktifDurum) {
            setBackground(aktifRenk);
            setIcon(aktifIcon);
        } else {
            setBackground(pasifRenk);
            setIcon(pasifIcon);
        }
    }

    private void executeGraphQLMutation() {
        // GraphQL mutation'ını çalıştırmak için mantığı uygula
        // graphQLSchemaAdresi ve diğer özellikleri gerektiği gibi kullan
        System.out.println(buttonText + " için GraphQL mutation çalıştırılıyor.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Buton Gridi");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(4, 4));

                // 4x4 buton gridi oluştur
                for (int i = 1; i <= 16; i++) {
                    CustomButton button = new CustomButton("Buton " + i, "http://ornek.com/graphql");
                    frame.add(button);
                }

                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
