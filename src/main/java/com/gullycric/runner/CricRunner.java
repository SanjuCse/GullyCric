package com.gullycric.runner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gullycric.model.Address;
import com.gullycric.model.BattingType;
import com.gullycric.model.BowlingType;
import com.gullycric.model.Coach;
import com.gullycric.model.CoachType;
import com.gullycric.model.Player;
import com.gullycric.model.Religion;
import com.gullycric.model.Team;
import com.gullycric.service.IAddressService;
import com.gullycric.service.ICoachService;
import com.gullycric.service.IPlayerService;
import com.gullycric.service.ITeamService;

@Component
public class CricRunner implements CommandLineRunner {
	@Autowired
	private IAddressService addressService;

	@Autowired
	private ICoachService coachService;

	@Autowired
	private IPlayerService playerService;

	@Autowired
	private ITeamService teamService;

	@Override
	public void run(String... args) throws Exception {

		/*
//		Bating Coach Details
		Address batingCoachAddress = new Address();
		batingCoachAddress.setCountry("India");
		batingCoachAddress.setPinCode(144001);
		batingCoachAddress.setCity("Jalandhar");
		batingCoachAddress.setState("Punjab");

		Coach batingCoach = new Coach();
		batingCoach.setCoachType(CoachType.Bating);
		batingCoach.setName("Vikram Rathour");
		batingCoach.setAddress(batingCoachAddress);
		batingCoach.setDob(LocalDate.of(1969, Month.MARCH, 26));
		batingCoach.setHeight(6.0);
		batingCoach.setReligion(Religion.Sikhism);

//		Bowling Coach Details
		Address bowlingCoachAddress = new Address();
		bowlingCoachAddress.setCountry("India");
		bowlingCoachAddress.setPinCode(400001);
		bowlingCoachAddress.setCity("Mumbai");
		bowlingCoachAddress.setState("Maharastra");

		Coach bowlingCoach = new Coach();
		bowlingCoach.setCoachType(CoachType.Bowling);
		bowlingCoach.setName("Paras Mhambrey");
		bowlingCoach.setAddress(bowlingCoachAddress);
		bowlingCoach.setDob(LocalDate.of(1972, Month.JULY, 20));
		bowlingCoach.setHeight(5.9);
		bowlingCoach.setReligion(Religion.Hinduism);

//		Fielding Coach Details
		Address fieldingCoachAddress = new Address();
		fieldingCoachAddress.setCountry("India");
		fieldingCoachAddress.setPinCode(400002);
		fieldingCoachAddress.setCity("Mumbai");
		fieldingCoachAddress.setState("Maharastra");

		Coach fieldingCoach = new Coach();
		fieldingCoach.setCoachType(CoachType.Fielding);
		fieldingCoach.setName("T Dilip");
		fieldingCoach.setAddress(fieldingCoachAddress);
		fieldingCoach.setDob(LocalDate.of(1985, Month.MAY, 15));
		fieldingCoach.setHeight(5.8);
		fieldingCoach.setReligion(Religion.Hinduism);

//		Head Coach Details
		Address headCoachAddress = new Address();
		headCoachAddress.setCountry("India");
		headCoachAddress.setPinCode(451010);
		headCoachAddress.setCity("Indore");
		headCoachAddress.setState("Madya Pradesh");

		Coach headCoach = new Coach();
		headCoach.setCoachType(CoachType.Head);
		headCoach.setName("Rahul Dravid");
		headCoach.setAddress(headCoachAddress);
		headCoach.setDob(LocalDate.of(1973, Month.JANUARY, 11));
		headCoach.setHeight(5.11);
		headCoach.setReligion(Religion.Hinduism);

//		Team Details
		Address teamAddress = new Address();
		teamAddress.setCountry("India");
		teamAddress.setPinCode(400020);
		teamAddress.setCity("Mumbai");
		teamAddress.setState("Maharastra");

		Team team = new Team();
		team.setAddress(teamAddress);
		team.setCoachs(List.of(batingCoach, bowlingCoach, fieldingCoach, headCoach));
		team.setFormationDate(LocalDate.of(1932, Month.JUNE, 25));
		team.setHistory(
				"The India men's national cricket team represent India in men's international cricket. It is governed by the Board of Control for Cricket in India (BCCI), and is a Full Member of the International Cricket Council (ICC) with Test.");

		team.setName("India national cricket team");
		team.setOwner("BCCI");
		team.setSponsorship("SAHARA INDIA");

		Player rohitSharma = new Player();
		rohitSharma.setName("Rohit Sharma");
		rohitSharma.setAddress(new Address("India", "Maharastra", "Nagpur", 440001));
		rohitSharma.setBattingType(BattingType.RightHanded);
		rohitSharma.setBowlingType(BowlingType.FingerSpinner);
		rohitSharma.setDob(LocalDate.of(1987, Month.APRIL, 30));
		rohitSharma.setHeight(5.9);
		rohitSharma.setIsCaptain(true);
		rohitSharma.setNickName("shaana");
		rohitSharma.setReligion(Religion.Hinduism);
		rohitSharma.setTeam(team);

		Player viratKohli = new Player();
		viratKohli.setName("Virat Kohli");
		viratKohli.setAddress(new Address("India", "Delhi", "Delhi", 110001));
		viratKohli.setBattingType(BattingType.RightHanded);
		viratKohli.setBowlingType(BowlingType.FingerSpinner);
		viratKohli.setDob(LocalDate.of(1988, Month.NOVEMBER, 5));
		viratKohli.setHeight(5.9);
		viratKohli.setNickName("chiku");
		viratKohli.setReligion(Religion.Hinduism);
		viratKohli.setTeam(team);

		Player subhmanGill = new Player();
		subhmanGill.setName("Subhman Gill");
		subhmanGill.setAddress(new Address("India", "Punjab", "Fazlika", 152123));
		subhmanGill.setBattingType(BattingType.RightHanded);
		subhmanGill.setBowlingType(BowlingType.FingerSpinner);
		subhmanGill.setDob(LocalDate.of(1999, Month.SEPTEMBER, 8));
		subhmanGill.setHeight(6.1);
		subhmanGill.setNickName("Gill");
		subhmanGill.setReligion(Religion.Sikhism);
		subhmanGill.setTeam(team);

		Player klRahul = new Player();
		klRahul.setName("K L Rahul");
		klRahul.setAddress(new Address("India", "Karnatak", "Bengaluru", 500368));
		klRahul.setBattingType(BattingType.RightHanded);
		klRahul.setBowlingType(BowlingType.FingerSpinner);
		klRahul.setDob(LocalDate.of(1992, Month.APRIL, 18));
		klRahul.setHeight(6.0);
		klRahul.setNickName("Rahul");
		klRahul.setReligion(Religion.Hinduism);
		klRahul.setTeam(team);

		Player suryaKumarYadav = new Player();
		suryaKumarYadav.setName("Surya Kumar Yadav");
		suryaKumarYadav.setAddress(new Address("India", "Karnatak", "Bengaluru", 500368));
		suryaKumarYadav.setBattingType(BattingType.RightHanded);
		suryaKumarYadav.setBowlingType(BowlingType.FingerSpinner);
		suryaKumarYadav.setDob(LocalDate.of(1990, Month.SEPTEMBER, 14));
		suryaKumarYadav.setHeight(5.11);
		suryaKumarYadav.setNickName("SKY");
		suryaKumarYadav.setReligion(Religion.Hinduism);
		suryaKumarYadav.setTeam(team);

		Player hardikPandya = new Player();
		hardikPandya.setName("Hardik Pandya");
		hardikPandya.setAddress(new Address("India", "Gujurat", "Surat", 394150));
		hardikPandya.setBattingType(BattingType.RightHanded);
		hardikPandya.setBowlingType(BowlingType.Swing);
		hardikPandya.setDob(LocalDate.of(1993, Month.OCTOBER, 11));
		hardikPandya.setHeight(6.0);
		hardikPandya.setNickName("Hardy");
		hardikPandya.setReligion(Religion.Hinduism);
		hardikPandya.setTeam(team);

		Player ravindraJadeja = new Player();
		ravindraJadeja.setName("Ravindra Jadeja");
		ravindraJadeja.setAddress(new Address("India", "Gujurat", "Navagam Ghed", 361008));
		ravindraJadeja.setBattingType(BattingType.LeftHanded);
		ravindraJadeja.setBowlingType(BowlingType.FingerSpinner);
		ravindraJadeja.setDob(LocalDate.of(1988, Month.DECEMBER, 6));
		ravindraJadeja.setHeight(5.8);
		ravindraJadeja.setNickName("Jaadu");
		ravindraJadeja.setReligion(Religion.Hinduism);
		ravindraJadeja.setTeam(team);

		Player kuldeepYadav = new Player();
		kuldeepYadav.setName("Kuldeep Yadav");
		kuldeepYadav.setAddress(new Address("India", "Uttar Pradesh", "Kanpur", 208001));
		kuldeepYadav.setBattingType(BattingType.LeftHanded);
		kuldeepYadav.setBowlingType(BowlingType.WristSpinner);
		kuldeepYadav.setDob(LocalDate.of(1994, Month.DECEMBER, 14));
		kuldeepYadav.setHeight(5.6);
		kuldeepYadav.setNickName("KD");
		kuldeepYadav.setReligion(Religion.Hinduism);
		kuldeepYadav.setTeam(team);

		Player jaspritBumrah = new Player();
		jaspritBumrah.setName("Jasprit Bumrah");
		jaspritBumrah.setAddress(new Address("India", "Gujurat", "Ahmedabad", 320008));
		jaspritBumrah.setBattingType(BattingType.RightHanded);
		jaspritBumrah.setBowlingType(BowlingType.Swing);
		jaspritBumrah.setDob(LocalDate.of(1993, Month.DECEMBER, 6));
		jaspritBumrah.setHeight(5.9);
		jaspritBumrah.setNickName("Boom Boom");
		jaspritBumrah.setReligion(Religion.Hinduism);
		jaspritBumrah.setTeam(team);

		Player mohammedShami = new Player();
		mohammedShami.setName("Mohammed Shami");
		mohammedShami.setAddress(new Address("India", "Uttar Pradesh", "Amroha", 244221));
		mohammedShami.setBattingType(BattingType.RightHanded);
		mohammedShami.setBowlingType(BowlingType.Swing);
		mohammedShami.setDob(LocalDate.of(1990, Month.SEPTEMBER, 3));
		mohammedShami.setHeight(5.8);
		mohammedShami.setNickName("shami");
		mohammedShami.setReligion(Religion.Muslim);
		mohammedShami.setTeam(team);

		Player mohammedSiraj = new Player();
		mohammedSiraj.setName("Mohammed Siraj");
		mohammedSiraj.setAddress(new Address("India", "Telengana", "Hyderabad", 500001));
		mohammedSiraj.setBattingType(BattingType.LeftHanded);
		mohammedSiraj.setBowlingType(BowlingType.Pace);
		mohammedSiraj.setDob(LocalDate.of(1994, Month.MARCH, 13));
		mohammedSiraj.setHeight(5.10);
		mohammedSiraj.setNickName("Siraj");
		mohammedSiraj.setReligion(Religion.Muslim);
		mohammedSiraj.setTeam(team);

		Player ishanKishan = new Player();
		ishanKishan.setName("Ishan Kishan");
		ishanKishan.setAddress(new Address("India", "Bihar", "Patna", 800001));
		ishanKishan.setBattingType(BattingType.LeftHanded);
		ishanKishan.setBowlingType(BowlingType.FingerSpinner);
		ishanKishan.setDob(LocalDate.of(1998, Month.JULY, 18));
		ishanKishan.setHeight(5.6);
		ishanKishan.setNickName("ishaan");
		ishanKishan.setReligion(Religion.Hinduism);
		ishanKishan.setTeam(team);

		Player shardulThakur = new Player();
		shardulThakur.setName("Shardul Thakur");
		shardulThakur.setAddress(new Address("India", "Maharashtra", "Palghar", 401404));
		shardulThakur.setBattingType(BattingType.RightHanded);
		shardulThakur.setBowlingType(BowlingType.Pace);
		shardulThakur.setDob(LocalDate.of(1991, Month.OCTOBER, 16));
		shardulThakur.setHeight(5.9);
		shardulThakur.setNickName("Lord Thakur");
		shardulThakur.setReligion(Religion.Hinduism);
		shardulThakur.setTeam(team);

		Player prasidhKrishna = new Player();
		prasidhKrishna.setName("Prasidh Krishna");
		prasidhKrishna.setAddress(new Address("India", "Karnataka", "Bangolore", 530068));
		prasidhKrishna.setBattingType(BattingType.RightHanded);
		prasidhKrishna.setBowlingType(BowlingType.Pace);
		prasidhKrishna.setDob(LocalDate.of(1996, Month.FEBRUARY, 19));
		prasidhKrishna.setHeight(6.2);
		prasidhKrishna.setNickName("Krishna");
		prasidhKrishna.setReligion(Religion.Hinduism);
		prasidhKrishna.setTeam(team);

		Player ravichandranAshwin = new Player();
		ravichandranAshwin.setName("Ravichandran Ashwin");
		ravichandranAshwin.setAddress(new Address("India", "Tamil nadu", "Chennai", 600001));
		ravichandranAshwin.setBattingType(BattingType.RightHanded);
		ravichandranAshwin.setBowlingType(BowlingType.FingerSpinner);
		ravichandranAshwin.setDob(LocalDate.of(1986, Month.SEPTEMBER, 17));
		ravichandranAshwin.setHeight(6.2);
		ravichandranAshwin.setNickName("Ash");
		ravichandranAshwin.setReligion(Religion.Hinduism);
		ravichandranAshwin.setTeam(team);

		team.setPlayers(List.of(rohitSharma, viratKohli, subhmanGill, klRahul, suryaKumarYadav, hardikPandya,
				ravindraJadeja, kuldeepYadav, jaspritBumrah, mohammedShami, mohammedSiraj, ishanKishan, shardulThakur,
				prasidhKrishna, ravichandranAshwin));
		team.setPlayerCount(team.getPlayers().size());
		team.setCaptain(rohitSharma);

		teamAddress.setTeam(team);
		headCoachAddress.setCoach(headCoach);
		batingCoachAddress.setCoach(batingCoach);
		bowlingCoachAddress.setCoach(bowlingCoach);
		fieldingCoachAddress.setCoach(fieldingCoach);
		
		batingCoach.setTeam(team);
		bowlingCoach.setTeam(team);
		fieldingCoach.setTeam(team);
		headCoach.setTeam(team);

		playerService.addPlayer(rohitSharma);
		playerService.addPlayer(viratKohli);
		playerService.addPlayer(subhmanGill);
		playerService.addPlayer(klRahul);
		playerService.addPlayer(suryaKumarYadav);
		playerService.addPlayer(hardikPandya);
		playerService.addPlayer(ravindraJadeja);
		playerService.addPlayer(kuldeepYadav);
		playerService.addPlayer(jaspritBumrah);
		playerService.addPlayer(mohammedShami);
		playerService.addPlayer(mohammedSiraj);
		playerService.addPlayer(ishanKishan);
		playerService.addPlayer(shardulThakur);
		playerService.addPlayer(prasidhKrishna);
		playerService.addPlayer(ravichandranAshwin);

		addressService.addAddress(teamAddress);
		addressService.addAddress(headCoachAddress);
		addressService.addAddress(batingCoachAddress);
		addressService.addAddress(bowlingCoachAddress);
		addressService.addAddress(fieldingCoachAddress);

		coachService.addCoach(headCoach);
		coachService.addCoach(batingCoach);
		coachService.addCoach(bowlingCoach);
		coachService.addCoach(fieldingCoach);
		
		teamService.addTeam(team);
		
		*/
	}
}
