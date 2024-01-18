import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class MyWorld extends SWorld
{
    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    Label coins = new Label("0", 35);
    Label scoreRecord = new Label("0", 35);
    Label scoreLabel = new Label("score: ", 35);
    Label coinLabel = new Label("coins: ", 35);
    GreenfootSound music = new GreenfootSound("sounds/music.mp3");
    
    
    public MyWorld()
    {    
        super(800, 600, 1, 15500); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed in the center of the window
        GreenfootImage bg = new GreenfootImage("images/background.png");
        setMainActor(new Sonic(), 40, 1000); // the int parameters are centered window x and y ranges
        setScrollingBackground(bg);
        addObject(scoreRecord, 150, 35, false);
        addObject(coins, 150, 80, false);
        addObject(scoreLabel, 70, 35, false);
        addObject(coinLabel, 70, 80, false);
        //addObject(new Ground(), 400, 400, true);
        //addObject(new Crabmeat(), 500, 300, true);
        prepare();
        music.setVolume(35);
        music.playLoop();
        
    }
    
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,167,551);
        ground.setLocation(101,590);
        ground.setLocation(152,565);
        Ground ground2 = new Ground();
        addObject(ground2,704,493);
        ground2.setLocation(532,600);
        ground2.setLocation(454,554);
        ground2.setLocation(483,550);
        Ground ground3 = new Ground();
        addObject(ground3,763,446);
        ground3.setLocation(816,560);
        ground.setLocation(661,554);
        ground2.setLocation(1193,558);
        Ground ground4 = new Ground();
        addObject(ground4,1870,559);
        ground4.setLocation(2014,388);
        ground.setLocation(279,577);
        ground2.setLocation(753,567);
        ground3.setLocation(1164,580);
        ground4.setLocation(1808,654);
        ground4.setLocation(1862,553);
        ground4.setLocation(1832,555);
        Ground ground5 = new Ground();
        addObject(ground5,2592,514);
        ground5.setLocation(2501,579);
        Ground ground6 = new Ground();
        addObject(ground6,3111,511);
        ground6.setLocation(3113,567);
        Ground ground7 = new Ground();
        addObject(ground7,3768,525);
        ground7.setLocation(3659,577);
        Ground ground8 = new Ground();
        addObject(ground8,4316,554);
        ground8.setLocation(4325,578);
        Ground ground9 = new Ground();
        addObject(ground9,4705,528);
        ground9.setLocation(4786,567);
        ground6.setLocation(3049,421);
        ground4.setLocation(1717,573);
        ground4.setLocation(1707,559);
        ground8.setLocation(4428,551);
        ground9.setLocation(5073,549);
        ground9.setLocation(5053,579);
        Ground ground10 = new Ground();
        addObject(ground10,5191,395);
        ground10.setLocation(5356,416);
        Ground ground11 = new Ground();
        addObject(ground11,5671,547);
        ground11.setLocation(5895,552);
        Ground ground12 = new Ground();
        addObject(ground12,6331,563);
        ground12.setLocation(6423,583);
        Ground ground13 = new Ground();
        addObject(ground13,7063,587);
        ground13.setLocation(7238,576);
        ground13.setLocation(7938,562);
        Ground ground14 = new Ground();
        addObject(ground14,7032,451);
        ground14.setLocation(7128,426);
        ground10.setLocation(5311,369);
        ground10.setLocation(5389,375);
        ground11.setLocation(5608,545);
        ground12.setLocation(6231,564);
        ground14.setLocation(7276,418);
        ground12.setLocation(6691,558);
        ground11.setLocation(5821,560);
        Ground ground15 = new Ground();
        addObject(ground15,792,344);
        ground15.setLocation(861,370);
        Ground ground16 = new Ground();
        addObject(ground16,1145,158);
        ground16.setLocation(1632,210);
        Ground ground17 = new Ground();
        addObject(ground17,2073,286);
        ground17.setLocation(2198,284);
        Ground ground18 = new Ground();
        addObject(ground18,3260,164);
        ground18.setLocation(2701,150);
        ground18.setLocation(2763,167);
        Ground ground19 = new Ground();
        addObject(ground19,3575,294);
        ground19.setLocation(3673,283);
        ground19.setLocation(3811,265);
        Ground ground20 = new Ground();
        addObject(ground20,4294,354);
        ground20.setLocation(4379,394);
        ground19.setLocation(3546,273);
        ground20.setLocation(4624,413);
        ground20.setLocation(4320,397);
        ground10.setLocation(4914,282);
        Ground ground21 = new Ground();
        addObject(ground21,6159,346);
        ground21.setLocation(5999,376);
        ground17.setLocation(2033,390);
        ground17.setLocation(2376,397);
        ground18.setLocation(2738,196);
        ground17.setLocation(2414,405);
        ground17.setLocation(2177,404);
        ground17.setLocation(2177,404);
        ground10.setLocation(5204,275);
        ground20.setLocation(4032,363);
        ground8.setLocation(4289,582);
        ground20.setLocation(4476,330);
        ground8.setLocation(4205,551);
        ground20.setLocation(4176,389);
        ground19.setLocation(3762,273);
        ground17.setLocation(2486,394);
        ground18.setLocation(2679,216);
        ground10.setLocation(4989,329);
        ground10.setLocation(5074,325);
        ground21.setLocation(5510,338);
        Ground ground22 = new Ground();
        addObject(ground22,6913,268);
        ground22.setLocation(6180,275);
        ground21.setLocation(5938,428);
        ground22.setLocation(6423,296);
        ground21.setLocation(5907,348);
        ground21.setLocation(5812,364);
        ground20.setLocation(4204,386);
        ground17.setLocation(2340,399);
        ground17.setLocation(2015,369);
        ground16.setLocation(1479,268);
        ground17.setLocation(2127,363);
        ground18.setLocation(2839,244);
        ground21.setLocation(5855,334);
        ground20.setLocation(4566,388);
        ground19.setLocation(3727,302);
        ground12.setLocation(6541,565);
        ground14.setLocation(7297,502);
        Ground ground23 = new Ground();
        addObject(ground23,7132,226);
        ground23.setLocation(7169,227);
        ground20.setLocation(4430,369);
        ground8.setLocation(4105,550);
        ground20.setLocation(4445,370);
        ground10.setLocation(5223,330);
        ground21.setLocation(5848,237);
        ground22.setLocation(6377,347);
        ground10.setLocation(5139,314);
        ground21.setLocation(5821,228);
        ground22.setLocation(6416,293);
        ground23.setLocation(7288,220);
        ground14.setLocation(7212,489);
        ground22.setLocation(6518,290);
        ground22.setLocation(6651,296);
        ground22.setLocation(6560,289);
        ground22.setLocation(6419,286);
        ground22.setLocation(6530,302);
        ground17.setLocation(2304,347);
        ground18.setLocation(2966,193);
        ground17.setLocation(2190,318);
        ground6.setLocation(3070,397);
        ground18.setLocation(2724,162);
        ground17.setLocation(2104,353);
        ground19.setLocation(3682,296);
        ground20.setLocation(4507,407);
        ground20.setLocation(4634,397);
        ground9.setLocation(4827,565);
        ground9.setLocation(4948,536);
        ground9.setLocation(5075,554);
        Ground ground24 = new Ground();
        addObject(ground24,5337,580);
        ground24.setLocation(5375,532);
        ground9.setLocation(4989,582);
        ground24.setLocation(5227,543);
        ground20.setLocation(4464,357);
        ground20.setLocation(4473,350);
        ground20.setLocation(4282,342);
        ground10.setLocation(5164,182);
        ground21.setLocation(5830,308);
        ground22.setLocation(6409,243);
        ground21.setLocation(5744,324);
        ground15.setLocation(791,368);
        ground20.setLocation(4473,331);
        ground24.setLocation(5437,550);
        ground19.setLocation(3792,288);
        ground19.setLocation(3833,270);
        ground19.setLocation(3746,276);
        ground15.setLocation(835,353);
        ground17.setLocation(2396,328);
        ground6.setLocation(2980,394);
        ground10.setLocation(5156,210);
        ground21.setLocation(5689,368);
        ground21.setLocation(5923,339);
        ground22.setLocation(6262,277);
        ground23.setLocation(7425,264);
        ground23.setLocation(7186,282);
        ground22.setLocation(6711,162);
        ground23.setLocation(7456,236);
        ground22.setLocation(6446,183);
        ground22.setLocation(6675,184);
        ground23.setLocation(7264,227);
        Ground ground25 = new Ground();
        addObject(ground25,7065,56);
        ground25.setLocation(6644,96);
        ground25.setLocation(5685,119);
        ground25.setLocation(5864,150);
        ground21.setLocation(5825,338);
        ground21.setLocation(5835,344);
        ground23.setLocation(7385,281);
        ground21.setLocation(6021,345);
        ground17.setLocation(2190,385);
        ground17.setLocation(2199,362);
        ground17.setLocation(2233,359);
        ground15.setLocation(1030,371);
        ground15.setLocation(681,356);
        ground15.setLocation(945,342);
        ground15.setLocation(885,385);
        ground15.setLocation(895,391);
        ground15.setLocation(846,373);
        ground15.setLocation(910,388);
        ground15.setLocation(849,365);
        Coins coins = new Coins();
        addObject(coins,611,285);
        Coins coins2 = new Coins();
        addObject(coins2,674,283);
        Coins coins3 = new Coins();
        addObject(coins3,738,282);
        Coins coins4 = new Coins();
        addObject(coins4,802,281);
        Coins coins5 = new Coins();
        addObject(coins5,858,278);
        coins2.setLocation(661,285);
        coins3.setLocation(706,287);
        coins4.setLocation(758,283);
        coins5.setLocation(811,279);
        Coins coins6 = new Coins();
        addObject(coins6,862,279);
        Coins coins7 = new Coins();
        addObject(coins7,915,280);
        roundTree roundTree = new roundTree(200);
        addObject(roundTree,666,216);
        roundTree.setLocation(667,229);
        Coins coins8 = new Coins();
        addObject(coins8,968,280);
        Coins coins9 = new Coins();
        addObject(coins9,1095,199);
        Coins coins10 = new Coins();
        addObject(coins10,1132,144);
        Coins coins11 = new Coins();
        addObject(coins11,1196,165);
        Coins coins12 = new Coins();
        addObject(coins12,1430,488);
        coins12.setLocation(1455,483);
        Coins coins13 = new Coins();
        addObject(coins13,1515,482);
        Coins coins14 = new Coins();
        addObject(coins14,1574,482);
        Coins coins15 = new Coins();
        addObject(coins15,1642,480);
        Coins coins16 = new Coins();
        addObject(coins16,1707,480);
        Coins coins17 = new Coins();
        addObject(coins17,1776,479);
        Bomb2 bomb2 = new Bomb2();
        addObject(bomb2,1710,173);
        bomb2.setLocation(1713,178);
        Crabmeat crabmeat = new Crabmeat();
        addObject(crabmeat,2644,90);
        crabmeat.setLocation(2650,84);
        Motobug motobug = new Motobug();
        addObject(motobug,2322,276);
        motobug.setLocation(2324,276);
        roundTree roundTree2 = new roundTree(200);
        addObject(roundTree2,2010,235);
        roundTree2.setLocation(2024,249);
        roundTree2.setLocation(2024,269);
        roundTree2.setLocation(2005,155);
        roundTree2.setLocation(2038,242);
        roundTree2.setLocation(2031,199);
        roundTree2.setLocation(2031,267);
        roundTree2.setLocation(2028,250);
        roundTree2.setLocation(2029,245);
        roundTree2.setLocation(2049,272);
        Coins coins18 = new Coins();
        addObject(coins18,1836,475);
        roundTree2.setLocation(2060,220);
        roundTree2.setLocation(1989,286);
        Coins coins19 = new Coins();
        addObject(coins19,1989,286);
        roundTree2.setLocation(2048,285);
        Coins coins20 = new Coins();
        addObject(coins20,2048,285);
        roundTree2.setLocation(2108,283);
        Coins coins21 = new Coins();
        addObject(coins21,2108,283);
        Coins coins22 = new Coins();
        addObject(coins22,2171,281);
        Coins coins23 = new Coins();
        addObject(coins23,2236,280);
        roundTree2.setLocation(2042,191);
        roundTree2.setLocation(2029,208);
        roundTree2.setLocation(2039,231);
        buzzBomber buzzBomber = new buzzBomber();
        addObject(buzzBomber,3261,132);
        ground19.setLocation(4010,281);
        Blue blue = new Blue();
        addObject(blue,4010,281);
        ground19.setLocation(4006,278);
        roundTree roundTree3 = new roundTree(200);
        addObject(roundTree3,3203,273);
        roundTree3.setLocation(3207,287);
        roundTree3.setLocation(3189,264);
        ground19.setLocation(3567,290);
        ground19.setLocation(3719,296);
        roundTree roundTree4 = new roundTree(200);
        addObject(roundTree4,4042,416);
        roundTree4.setLocation(3966,184);
        roundTree4.setLocation(3965,155);
        roundTree4.setLocation(3705,144);
        roundTree4.setLocation(3712,175);
        ground19.setLocation(3987,302);
        ground19.setLocation(3870,298);
        ground19.setLocation(3845,310);
        ground19.setLocation(3821,296);
        ground19.setLocation(3755,312);
        ground19.setLocation(3527,302);
        ground19.setLocation(3529,313);
        ground19.setLocation(3799,315);
        ground19.setLocation(3741,319);
        ground19.setLocation(4012,324);
        ground19.setLocation(3735,358);
        ground19.setLocation(3707,333);
        roundTree4.setLocation(3737,162);
        ground19.setLocation(3716,326);
        ground19.setLocation(3829,313);
        ground19.setLocation(3664,322);
        ground19.setLocation(3771,318);
        ground19.setLocation(3726,263);
        ground19.setLocation(3688,293);
        ground19.setLocation(3770,301);
        ground19.setLocation(3766,324);
        ground19.setLocation(3823,300);
        ground19.setLocation(3701,334);
        ground19.setLocation(3694,332);
        ground19.setLocation(3684,344);
        ground19.setLocation(3725,320);
        roundTree4.setLocation(3744,188);
        ground19.setLocation(3996,321);
        ground19.setLocation(3636,301);
        ground19.setLocation(3724,354);
        roundTree4.setLocation(3646,169);
        roundTree4.setLocation(3626,222);
        roundTree4.setLocation(3646,166);
        ground19.setLocation(3700,306);
        blue.setLocation(3976,314);
        ground19.setLocation(4208,333);
        ground19.setLocation(3573,302);
        ground19.setLocation(3700,326);
        roundTree4.setLocation(3650,171);
        Coins coins24 = new Coins();
        addObject(coins24,2717,316);
        roundTree3.setLocation(3156,319);
        Caterkiller caterkiller = new Caterkiller();
        addObject(caterkiller,3156,319);
        roundTree3.setLocation(3156,322);
        Coins coins25 = new Coins();
        addObject(coins25,2773,314);
        Coins coins26 = new Coins();
        addObject(coins26,2828,313);
        Coins coins27 = new Coins();
        addObject(coins27,2882,313);
        Coins coins28 = new Coins();
        addObject(coins28,2935,313);
        Coins coins29 = new Coins();
        addObject(coins29,2989,309);
        motobug.setLocation(2327,274);
        bomb2.setLocation(1932,441);
        bomb2.setLocation(2364,459);
        bomb2.setLocation(2592,493);
        Crabmeat crabmeat2 = new Crabmeat();
        addObject(crabmeat2,1699,175);
        crabmeat2.setLocation(1703,192);
        ground20.setLocation(4520,272);
        Coins coins30 = new Coins();
        addObject(coins30,3422,504);
        Coins coins31 = new Coins();
        addObject(coins31,3493,503);
        Coins coins32 = new Coins();
        addObject(coins32,3563,500);
        Coins coins33 = new Coins();
        addObject(coins33,3635,497);
        Coins coins34 = new Coins();
        addObject(coins34,3709,495);
        removeObject(ground21);
        ground25.setLocation(5994,309);
        ground23.setLocation(7524,217);
        tallTree tallTree = new tallTree(350, 125);
        addObject(tallTree,4834,453);
        tallTree.setLocation(4860,366);
        tallTree tallTree2 = new tallTree(300, 125);
        addObject(tallTree2,5018,375);
        tallTree2.setLocation(5068,401);
        tallTree2.setLocation(5097,389);
        tallTree tallTree3 = new tallTree(350, 125);
        addObject(tallTree3,5184,338);
        tallTree3.setLocation(5359,337);
        roundTree3.setLocation(3183,246);
        roundTree4.setLocation(3668,201);
        ground20.setLocation(4511,270);
        ground20.setLocation(4512,271);
        ground20.setLocation(4512,271);
        ground25.setLocation(5957,292);
        ground25.setLocation(5955,288);
        ground25.setLocation(5913,293);
        ground6.setLocation(2996,375);
        roundTree3.setLocation(3151,307);
        ground10.setLocation(5263,206);
        roundTree3.setLocation(3145,237);
        ground6.setLocation(3032,387);
        roundTree3.setLocation(3154,245);
        ground6.setLocation(3116,410);
        coins29.setLocation(3023,307);
        coins28.setLocation(2958,309);
        ground6.setLocation(3130,397);
        ground19.setLocation(3885,338);
        coins27.setLocation(2892,309);
        coins28.setLocation(2949,315);
        coins29.setLocation(3003,312);
        ground6.setLocation(3003,375);
        ground6.setLocation(3050,377);
        ground6.setLocation(3050,380);
        ground19.setLocation(3707,333);
        ground19.setLocation(3847,357);
        ground19.setLocation(3845,357);
        Ground ground26 = new Ground();
        addObject(ground26,4189,61);
        removeObject(ground19);
        ground26.setLocation(3686,348);
        ground26.setLocation(3831,363);
        ground26.setLocation(3828,412);
        removeObject(blue);
        ground26.setLocation(3860,365);
        ground26.setLocation(3921,341);
        ground26.setLocation(3676,360);
        ground26.setLocation(3768,384);
        ground26.setLocation(3874,366);
        ground26.setLocation(3735,321);
        ground26.setLocation(3902,331);
        roundTree4.setLocation(3672,177);
        ground26.setLocation(3633,336);
        ground26.setLocation(3797,321);
        ground25.setLocation(5974,266);
        ground20.setLocation(4622,306);
        Motobug motobug2 = new Motobug();
        addObject(motobug2,5675,445);
        motobug2.setLocation(5679,466);
        Coins coins35 = new Coins();
        addObject(coins35,4290,181);
        Coins coins36 = new Coins();
        addObject(coins36,4353,177);
        Coins coins37 = new Coins();
        addObject(coins37,4423,175);
        Coins coins38 = new Coins();
        addObject(coins38,4486,174);
        Coins coins39 = new Coins();
        addObject(coins39,4560,173);
        Coins coins40 = new Coins();
        addObject(coins40,4628,173);
        ground9.setLocation(4745,565);
        ground20.setLocation(4300,228);
        ground9.setLocation(4936,561);
        ground20.setLocation(4560,259);
        ground23.setLocation(7262,223);
        Blue blue2 = new Blue();
        addObject(blue2,7262,223);
        tallTree3.setLocation(5351,349);
        Green green = new Green();
        addObject(green,5351,349);
        Crabmeat crabmeat3 = new Crabmeat();
        addObject(crabmeat3,6045,180);
        Coins coins41 = new Coins();
        addObject(coins41,5029,124);
        Coins coins42 = new Coins();
        addObject(coins42,5089,122);
        Coins coins43 = new Coins();
        addObject(coins43,5150,119);
        coins43.setLocation(5151,123);
        Coins coins44 = new Coins();
        addObject(coins44,5209,123);
        Coins coins45 = new Coins();
        addObject(coins45,5266,120);
        Coins coins46 = new Coins();
        addObject(coins46,5322,118);
        Coins coins47 = new Coins();
        addObject(coins47,5758,191);
        Coins coins48 = new Coins();
        addObject(coins48,5815,190);
        Coins coins49 = new Coins();
        addObject(coins49,5872,188);
        Coins coins50 = new Coins();
        addObject(coins50,5933,187);
        ground23.setLocation(7544,249);
        buzzBomber buzzBomber2 = new buzzBomber();
        addObject(buzzBomber2,4276,464);
        buzzBomber2.setLocation(4278,467);
        Crabmeat crabmeat4 = new Crabmeat();
        addObject(crabmeat4,3839,246);
        crabmeat4.setLocation(3854,241);
        Bomb1 bomb1 = new Bomb1();
        addObject(bomb1,4779,163);
        bomb1.setLocation(4778,172);
        BatBrain batBrain = new BatBrain();
        addObject(batBrain,6231,320);
        Coins coins51 = new Coins();
        addObject(coins51,4679,488);
        Coins coins52 = new Coins();
        addObject(coins52,4729,485);
        Coins coins53 = new Coins();
        addObject(coins53,4777,482);
        tallTree.setLocation(4828,482);
        Coins coins54 = new Coins();
        addObject(coins54,4828,482);
        tallTree.setLocation(4882,484);
        Coins coins55 = new Coins();
        addObject(coins55,4882,484);
        Coins coins56 = new Coins();
        addObject(coins56,4929,482);
        roundTree roundTree5 = new roundTree(200);
        addObject(roundTree5,6387,453);
        roundTree5.setLocation(6385,437);
        roundTree roundTree6 = new roundTree(200);
        addObject(roundTree6,7033,381);
        roundTree6.setLocation(7047,369);
        roundTree roundTree7 = new roundTree(200);
        addObject(roundTree7,7772,131);
        roundTree7.setLocation(7769,139);
        Coins coins57 = new Coins();
        addObject(coins57,7307,173);
        coins57.setLocation(7311,173);
        Coins coins58 = new Coins();
        addObject(coins58,7363,169);
        coins58.setLocation(7362,171);
        Coins coins59 = new Coins();
        addObject(coins59,7417,168);
        Coins coins60 = new Coins();
        addObject(coins60,7472,164);
        Coins coins61 = new Coins();
        addObject(coins61,7527,163);
        Coins coins62 = new Coins();
        addObject(coins62,7583,162);
        Coins coins63 = new Coins();
        addObject(coins63,7155,410);
        Coins coins64 = new Coins();
        addObject(coins64,7214,409);
        Coins coins65 = new Coins();
        addObject(coins65,7275,405);
        Coins coins66 = new Coins();
        addObject(coins66,7343,405);
        Coins coins67 = new Coins();
        addObject(coins67,7408,401);
        coins67.setLocation(7405,407);
        Coins coins68 = new Coins();
        addObject(coins68,7466,403);
        coins24.setLocation(3049,310);
        BatBrain batBrain2 = new BatBrain();
        addObject(batBrain2,7634,375);
        batBrain2.setLocation(7638,302);
        ground14.setLocation(6934,480);
        Green green2 = new Green();
        addObject(green2,6934,480);
        buzzBomber buzzBomber3 = new buzzBomber();
        addObject(buzzBomber3,7433,449);
        removeObject(buzzBomber3);
        Motobug motobug3 = new Motobug();
        addObject(motobug3,6862,101);
        motobug3.setLocation(6856,103);
        roundTree7.setLocation(7766,101);
        Green green3 = new Green();
        addObject(green3,7766,101);
        roundTree7.setLocation(7768,105);
        ground14.setLocation(7425,485);
        ground14.setLocation(7253,499);
        ground14.setLocation(7254,503);
        ground14.setLocation(7271,509);
        roundTree6.setLocation(7053,362);
        ground14.setLocation(7124,519);
        ground14.setLocation(7381,452);
        ground14.setLocation(7080,463);
        ground14.setLocation(7314,478);
        ground14.setLocation(7305,496);
        roundTree6.setLocation(7030,363);
        ground14.setLocation(7187,503);
        ground14.setLocation(7334,512);
        ground14.setLocation(7404,521);
        ground14.setLocation(7400,521);
        ground14.setLocation(7136,508);
        ground14.setLocation(7421,520);
        ground14.setLocation(7264,499);
        green2.setLocation(7006,508);
        Spikes spikes = new Spikes();
        addObject(spikes,3317,305);
        spikes.setLocation(3313,302);
        Spikes spikes2 = new Spikes();
        addObject(spikes2,5529,134);
        spikes2.setLocation(5531,126);
        tallTree.setLocation(4869,260);
        Spikes spikes3 = new Spikes();
        addObject(spikes3,4136,486);
        spikes3.setLocation(4136,469);
        Spikes spikes4 = new Spikes();
        addObject(spikes4,6096,485);
        spikes4.setLocation(6091,483);
        roundTree7.setLocation(7812,179);
        Spikes spikes5 = new Spikes();
        addObject(spikes5,7812,179);
        roundTree7.setLocation(7821,172);
        Spikes spikes6 = new Spikes();
        addObject(spikes6,7526,415);
        spikes6.setLocation(7526,419);
        tallTree.setLocation(4845,387);
        roundTree7.setLocation(7818,111);
        roundTree7.setLocation(7849,106);
        roundTree7.setLocation(7805,107);
        roundTree7.setLocation(7791,107);
        roundTree7.setLocation(7701,92);
        roundTree7.setLocation(7699,102);
        spikes5.setLocation(7814,191);
        roundTree3.setLocation(3227,318);
        removeObject(caterkiller);
        buzzBomber.setLocation(3253,138);
        Spring spring = new Spring();
        addObject(spring,3417,490);
        spring.setLocation(3403,506);
        coins30.setLocation(3360,510);
        coins34.setLocation(3763,497);
        coins33.setLocation(3703,497);
        coins32.setLocation(3623,500);
        coins32.setLocation(3633,501);
        coins31.setLocation(3568,503);
        coins30.setLocation(3522,505);
        coins32.setLocation(3648,504);
        coins31.setLocation(3581,506);
        coins32.setLocation(3643,506);
        coins33.setLocation(3709,507);
        coins34.setLocation(3766,506);
        spring.setLocation(3408,509);
        spikes3.setLocation(4141,483);
        Spring spring2 = new Spring();
        addObject(spring2,4205,495);
        spring2.setLocation(4204,480);
        Spring spring3 = new Spring();
        addObject(spring3,5620,484);
        spring3.setLocation(5625,483);
        ground11.setLocation(5561,550);
        motobug2.setLocation(6008,486);
        removeObject(motobug2);
        Caterkiller caterkiller2 = new Caterkiller();
        addObject(caterkiller2,5873,503);
        caterkiller2.setLocation(5895,489);
        ground11.setLocation(5890,556);
        ground11.setLocation(6033,561);
        ground11.setLocation(5400,559);
        ground9.setLocation(5656,537);
        ground24.setLocation(5886,561);
        ground11.setLocation(4850,537);
        ground11.setLocation(4877,540);
        ground11.setLocation(4900,574);
        tallTree.setLocation(4840,386);
        ground9.setLocation(5309,575);
        spring3.setLocation(5630,480);
        spring3.setLocation(5634,494);
        coins53.setLocation(4777,488);
        tallTree.setLocation(4832,492);
        tallTree.setLocation(4877,494);
        coins56.setLocation(4930,492);
        tallTree.setLocation(4857,279);
        tallTree.setLocation(4768,396);
        removeObject(roundTree3);
        buzzBomber2.setLocation(4387,349);
        Spring spring4 = new Spring();
        addObject(spring4,7137,425);
        spring4.setLocation(7137,431);
        spikes3.setLocation(4338,482);
        spikes3.setLocation(4386,497);
        ground8.setLocation(4370,498);
        spikes3.setLocation(4353,484);
        spikes3.setLocation(4365,482);
        End end = new End();
        addObject(end,7899,444);
        end.setLocation(7922,453);
        ground8.setLocation(4148,436);
        ground8.setLocation(4387,550);
        spring2.setLocation(4144,477);
        ground8.setLocation(4441,570);
        ground8.setLocation(4221,549);
        ground8.setLocation(4273,545);
        ground8.setLocation(4239,545);
        spring2.setLocation(4138,487);
        spikes3.setLocation(4344,495);
        ground8.setLocation(4235,572);
        spring2.setLocation(4146,502);
        spikes3.setLocation(4303,510);
        ground8.setLocation(4390,543);
        ground8.setLocation(4321,512);
        spikes3.setLocation(4337,504);
        spring2.setLocation(4142,504);
        ground8.setLocation(4179,565);
        ground8.setLocation(4187,537);
        spring2.setLocation(4134,487);
        ground8.setLocation(4374,501);
        ground8.setLocation(4355,555);
        ground8.setLocation(4391,543);
        ground8.setLocation(4341,502);
        ground8.setLocation(4252,547);
        spring2.setLocation(4130,483);
        ground8.setLocation(4366,476);
        ground8.setLocation(4330,540);
        ground8.setLocation(4296,545);
        spring2.setLocation(4142,491);
        ground8.setLocation(4336,503);
        ground8.setLocation(4540,523);
        ground8.setLocation(4375,546);
        ground8.setLocation(4011,562);
        spikes3.setLocation(4335,472);
        spring2.setLocation(4135,488);
        ground8.setLocation(4281,531);
        spikes3.setLocation(4336,483);
        spring2.setLocation(4144,480);
        ground8.setLocation(4226,563);
        spring2.setLocation(4118,501);
        spikes3.setLocation(4347,497);
        spring2.setLocation(4155,495);
    }
}