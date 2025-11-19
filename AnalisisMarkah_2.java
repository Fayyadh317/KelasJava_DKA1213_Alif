package LatihanNakPA_171125;

/**
 * Nama : AL FAYYADH BIN BOMIEDIN
 * Tarikh : 18 Nov 2025
 */
import java.util.Scanner;
public class AnalisisMarkah_2 {
    //PENGISYTIHARAN ARRAY SATU DIMENSI
    static String namaPelajar[];
    static double purataPertengahanTahun[];
    static double purataAkhirTahun[];
    static double purataAkhir[];
    static double purataAkhlak[];
    static double purataAqidah[];
    static double purataTajwid[];
    static String matapelajaran[] = {"Akhlak","Aqidah","Tajwid"};
    
    //PENGISYTIHARAN ARRAY DUA DIMENSI
    static double MarkahPertengahanTahun[][];
    static double MarkahAkhirTahun[][];
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int kodMenu;
        do{
            kodMenu = MainMenu(); 
            System.out.println(""); //Selang satu baris
            switch(kodMenu){
                case 1:
                    InputNama();
                    break;
            }
        }while(kodMenu!=5);
    }//Tamat main
    public static int MainMenu(){
        System.out.println("SISTEM PENCALONAN PENERIMA ANUGERAH SEKOLAH CENDANA");
        System.out.println("1. DAFTAR MURID\n2. INPUT MARKAH\n3. PAPAR MARKAH KESELURUHAN\n4. PAPAR ANALISIS MARKAH\n5. KELUAR");
        System.out.println("Pilih satu menu.");
        System.out.print("Masukkan nombor pilihan: ");
        int kodMenu = input.nextInt();
        return kodMenu;
    }//Tamat MainMenu
    public static void InputNama(){
        System.out.print("Sila Masukkan Bilangan Pelajar: ");
        int bilPelajar = input.nextInt();
        
        namaPelajar = new String[bilPelajar];
        purataPertengahanTahun = new double[bilPelajar];
        purataAkhirTahun = new double[bilPelajar];
        purataAkhir = new double[bilPelajar];
        purataAkhlak = new double[bilPelajar];
        purataAqidah = new double[bilPelajar];
        purataTajwid = new double[bilPelajar];
        
        MarkahPertengahanTahun = new double[bilPelajar][3];
        MarkahAkhirTahun = new double[bilPelajar][3];
        
        int i;
        for(i=0;i<namaPelajar.length;i++){
            System.out.print("Sila masukkan nama pelajar "+(i+1)+": ");
            namaPelajar[i] = input.nextLine();
        }
        
        System.out.println("Daftar Murid Selesai");
    }
    public static void InputMarkah(){
        System.out.println("***** INPUT MARKAH PEPERIKSAAN PERTENGAHAN TAHUN *****");
        
        //MARKAH PERTENGAHAN TAHUN
        int iT,cT; //i = baris, c = lajur
        for(iT=0;iT<namaPelajar.length;iT++){
            System.out.println("Pelajar "+(iT+1)+": "+namaPelajar[iT]);
            System.out.println(""); //Selang
            for(cT=0;cT<3;cT++){
                MarkahPertengahanTahun[iT][cT] = input.nextDouble();
            }
            System.out.println(""); //Selang
        }
        
        System.out.println(""); //Selang
        System.out.println("***** INPUT MARKAH PEPERIKSAAN AKHIR TAHUN *****");
        
        //MARKAH AKHIR TAHUN
        int iA,cA; //i = baris, c = lajur
        for(iA=0;iA<namaPelajar.length;iA++){
            System.out.println("Pelajar "+(iA+1)+": "+namaPelajar[iA]);
            System.out.println(""); //Selang
            for(cA=0;cA<3;cA++){
                MarkahAkhirTahun[iA][cA] = input.nextDouble();
            }
            System.out.println(""); //Selang
        }
        
        System.out.println("***** INPUT MARKAH SELESAI *****");
    }//Tamat InputMarkah()
    public static void KiraPurata(){
        //Purata markah pertengahan tahun
        int rT,cT;
        double purataT;
        for(rT=0;rT<namaPelajar.length;rT++){
            purataT = 0;
            for(cT=0;cT<3;cT++){
                purataT += MarkahPertengahanTahun[rT][cT];
            }
            purataPertengahanTahun[rT] = purataT/3;
        }
        
        //Purata markah akhir tahun
        int rA,cA;
        double purataA;
        for(rA=0;rA<namaPelajar.length;rA++){
            purataA = 0;
            for(cA=0;cA<3;cA++){
                purataA += MarkahAkhirTahun[rA][cA];
            }
            purataAkhirTahun[rA] = purataA/3;
        }
        
        //Purata markah setiap mata pelajaran
        double purataMarkahAkhlak=0, purataMarkahAqidah=0, purataMarkahTajwid=0;
        int r,c;
        for(r=0;r<namaPelajar.length;r++){
            purataMarkahAkhlak = MarkahPertengahanTahun[r][0]+MarkahAkhirTahun[r][0];
            purataMarkahAqidah = MarkahPertengahanTahun[r][1]+MarkahAkhirTahun[r][1];
            purataMarkahTajwid = MarkahPertengahanTahun[r][2]+MarkahAkhirTahun[r][2];
            
            purataAkhlak[r] = purataMarkahAkhlak/2;
            purataAqidah[r] = purataMarkahAqidah/2;
            purataTajwid[r] = purataMarkahTajwid/2;
        }
        
        //Purata markah keseluruhan
        for(r=0;r<namaPelajar.length;r++){
            purataAkhir[r] = (purataAkhlak[r]+purataAqidah[r]+purataTajwid[r])/3;
        }
    }
}//Tamat class
