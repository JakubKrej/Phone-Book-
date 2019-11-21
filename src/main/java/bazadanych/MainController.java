package bazadanych;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private OsobaRepo osobaRepo;

    @Autowired
    public MainController(OsobaRepo osobaRepo) {
        this.osobaRepo = osobaRepo;
    }

    @RequestMapping("/")
    public String stronaStartowa(){
        return "homePage";
    }



    @RequestMapping("/add")
    public String dodaj(
            @RequestParam(required = false) String imie ,
            @RequestParam(required = false) String nazwisko,
            @RequestParam(required = false) String telefon,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String opis, Model model)
            throws Exception {
        Osoba osoba = new Osoba(imie, nazwisko, telefon, email, opis, true);

        System.out.println(osoba);
        if(osoba.getImie() != null)
        osobaRepo.save(osoba);
        model.addAttribute("osoba", osoba);


        return "add";
    }


    @RequestMapping("/phoneBook")
    public String pokaz( Model model){
        for (Osoba osoba : osobaRepo.findAll()) {
            System.out.println(osoba);
        }

        model.addAttribute("osoba", osobaRepo.findAll());
        return "phoneBook";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model){
        osobaRepo.deleteById(id);

        model.addAttribute("osoba", osobaRepo.findAll());
        return "phonebook";
    }

    @RequestMapping("/serch")
    public String wyszukaj(@RequestParam("kryteria") String kryteria, Model model){

        System.out.println(kryteria);
        model.addAttribute("osoba", osobaRepo.findAllBynazwisko(kryteria));

        return "changes";
    }

    @RequestMapping("/upDate")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko,
            @RequestParam("telefon") String telefon,
            @RequestParam("email") String email,
            @RequestParam("opis") String opis, Model model)
            throws Exception {
        Osoba osoba = new Osoba(id, imie, nazwisko, telefon, email, opis, true);
        System.out.println(osoba);
        osobaRepo.save(osoba);
        model.addAttribute("osoba", osoba);
        return "phoneBook";
    }

    @RequestMapping("/changeDate")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(osobaRepo.findById(id));
        model.addAttribute("osoba", osobaRepo.findById(id));
        return "upDate";
    }
}
