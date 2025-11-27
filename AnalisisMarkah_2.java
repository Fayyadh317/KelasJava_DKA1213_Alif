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
                case 2:
                    if(namaPelajar == null){
                        System.out.println("***** TIADA DATA MURID *****");
                        System.out.println("\nSILA PILIH MENU 1 UNTUK DAFTAR MURID\n");
                    }
                    else{
                        InputMarkah();
                    }
                    break;
                case 3:
                    if(namaPelajar == null){
                        System.out.println("***** TIADA DATA MURID *****");
                        System.out.println("\nSILA PILIH MENU 1 UNTUK DAFTAR MURID\n");
                    }
                    else{
                        KiraPurata();
                        Display();
                    }
                    break;
                case 4:
                    if(namaPelajar == null){
                        System.out.println("***** TIADA DATA MURID *****");
                        System.out.println("\nSILA PILIH MENU 1 UNTUK DAFTAR MURID\n");
                    }
                    else{
                        SenaraiAnugerah();
                    }
                    break;
                case 5: //Keluar
                    System.out.println("\nANDA PASTI UNTUK KELUAR?");
                    System.out.print("Masukkan Y/y untuk YA, T/t untuk TIDAK: ");
                    char pilihanHuruf = input.next().charAt(0);
                    
                    if (pilihanHuruf == 'Y' || pilihanHuruf == 'y'){
                        System.out.println("******* Terima Kasih kerana menggunakan sistem ini *******");
                    }
                    else if(pilihanHuruf == 'T' || pilihanHuruf == 't'){
                        System.out.println(""); //Selang
                        kodMenu = 0; //Reset semula
                    }
                    else {
                        System.out.println("***** PILIHAN TIDAK SAH *****");
                        kodMenu = 0; //Reset semula
                    }
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
        input.nextLine(); //Alter semula bug skip input
        
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
                System.out.print("Markah subjek "+matapelajaran[cT]+": ");
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
                System.out.print("Markah subjek "+matapelajaran[cA]+": ");
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
    }//Tamat KiraPurata()
    public static void Display(){
        System.out.println("Markah Keseluruhan\n");
        
        //Display Markah Pertengahan Tahun
        System.out.println("---------- MARKAH PERTENGAHAN TAHUN ----------");
        System.out.println("Nama\t\tAkhlak\tAqidah\tTajwid\tPurata");

        for(int r=0;r<namaPelajar.length;r++){
            System.out.print(namaPelajar[r]+"\t\t");
            for(int c=0;c<matapelajaran.length;c++){
                System.out.print(MarkahPertengahanTahun[r][c]+"\t");
            }
            System.out.print(purataPertengahanTahun[r]+"\n");
        }
        System.out.println(""); //Jarak selang
        
        //Display Markah Akhir Tahun
        System.out.println("---------- MARKAH AKHIR TAHUN ----------");
        System.out.println("Nama\t\tAkhlak\tAqidah\tTajwid\tPurata");

        for(int r=0;r<namaPelajar.length;r++){
            System.out.print(namaPelajar[r]+"\t\t");
            for(int c=0;c<matapelajaran.length;c++){
                System.out.print(MarkahAkhirTahun[r][c]+"\t");
            }
            System.out.print(purataAkhirTahun[r]+"\n");
        }
        System.out.println(""); //Jarak selang
        
        //Display Purata
        System.out.println("---------- PURATA KESELURUHAN ----------");
        System.out.println("Nama\t\tAkhlak\tAqidah\tTajwid\tPurata");

        for(int r=0;r<namaPelajar.length;r++){
            System.out.print(namaPelajar[r]+"\t\t");
            System.out.print(purataAkhlak[r]+"\t"+purataAqidah[r]+"\t"+purataTajwid[r]+"\t");
            System.out.print(purataAkhir[r]+"\n");
        }
        System.out.println(""); //Jarak selang
        
    }//Tamat Display()
    public static String CariPenerimaAnugerah(double markah[][], int subjekArray){
        //Declare variable untuk nilai terendah dan nama
        double tertinggi = -1;
        String namaPenerima = "";
        
        //Loop untuk cari pelajar tertinggi
        for(int i=0;i<namaPelajar.length;i++){
            if(tertinggi < markah[i][subjekArray]){
                tertinggi = markah[i][subjekArray];
                namaPenerima = namaPelajar[i];
            }
        }
        
        return namaPenerima+" ("+tertinggi+")";
    } //Tamat CariPenerimaAnugerah()
    public static String CariPermataCemerlang(double markahPertengahan[][], double markahAkhir[][]){
        //Declare variable untuk nilai terendah dan nama
        double tertinggi = -1; //Nilai ini akan diganti lepas sistem jumpa nilai lain masa looping
        String namaPenerima = "";
        
        for(int i=0;i<namaPelajar.length;i++){
            double purata = (MarkahPertengahanTahun[i][0]+MarkahPertengahanTahun[i][1]+MarkahPertengahanTahun[i][2]+
                            MarkahAkhirTahun[i][0]+MarkahAkhirTahun[i][1]+MarkahAkhirTahun[i][2])/6;
            
            if(purata > tertinggi){ //Adakah purata yang diperoleh lebih tinggi daripada nilai tertinggi semasa?
                namaPenerima = namaPelajar[i];
            }
        }
        
        return namaPenerima;
    }//Tamat CariPermataCemerlang()
    public static void SenaraiAnugerah(){
        System.out.println("\n==== PENERIMA ANUGERAH ====\n");
        System.out.println("Anugerah Mata Pelajaran Akhlak: "+CariPenerimaAnugerah(MarkahAkhirTahun,0));
        System.out.println("Anugerah Mata Pelajaran Akidah: "+CariPenerimaAnugerah(MarkahAkhirTahun,1));
        System.out.println("Anugerah Mata Pelajaran Tajwid: "+CariPenerimaAnugerah(MarkahAkhirTahun,2));
        System.out.println("\nPermata Cemerlang: "+CariPermataCemerlang(MarkahPertengahanTahun,MarkahAkhirTahun));
    }//Tamat SenaraiAnugerah()
}//Tamat class
