package softeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LV2_6 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=626
     * 3 2
     * santafe
     * aerocity
     * porter
     * santafe 9 12
     * porter 9 18
     * 출력예제2
     * Room aerocity:
     * 1 available:
     * 09-18
     * -----
     * Room porter:
     * Not available
     * -----
     * Room santafe:
     * 1 available:
     * 12-18
     */


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int roomCount = Integer.parseInt(param[0]);
        int reserveCount = Integer.parseInt(param[1]);
        Map<String, Room> map = new HashMap<>();

        for(int i =0 ; i < roomCount ; i ++){
            String name = sc.nextLine();
            map.put(name, new Room(name));
        }

        for(int i =0; i < reserveCount ; i ++){
            String[] reserveInfo = sc.nextLine().split(" ");
            Room room = map.get(reserveInfo[0]);
            room.reserve(Integer.parseInt(reserveInfo[1]), Integer.parseInt(reserveInfo[2]));
        }

        List<String> names = map.keySet().stream().sorted().collect(Collectors.toList());

        for(int i =0 ; i < names.size() ; i++){
            if(i != 0 ){
                System.out.println("-----");
            }
            System.out.println(map.get(names.get(i)));
        }

    }

    static class Room implements Comparable<Room> {
        String name;
        boolean[] timeTable = new boolean[10];

        public Room(String name){
            this.name = name;
        }

        public void reserve(int start, int end){
            for(int i = start ; i < end; i++){
                timeTable[i-9] = true;
            }
        }

        private List<String> findEmptyRoom(){
            List<String> emptyRoom = new ArrayList<>();
            String temp = "";
            for(int i = 0; i < 9; i++){
                if(temp.length() == 0 && timeTable[i] == false){
                    if(i == 0){
                        temp += "09";
                    }else{
                        temp += (i+9);
                    }
                }
                if(temp.length() != 0 && timeTable[i] == true){
                    temp = temp + "-" +(i + 9);
                    emptyRoom.add(temp);
                    temp = "";

                }

            }

            if(temp.length() != 0 ){
                temp += "-18";
                emptyRoom.add(temp);
            }

            return emptyRoom;
        }

        @Override
        public int compareTo(Room o){
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Room ");
            sb.append(this.name);
            sb.append(": \n");


            List<String> emptyRoom = findEmptyRoom();
            if(emptyRoom.size() == 0){
                sb.append("Not available");
            }else{
                sb.append(emptyRoom.size());
                sb.append(" available:") ;
                for(int i =0; i < emptyRoom.size(); i++){
                    sb.append("\n");
                    sb.append(emptyRoom.get(i));
                }
            }

            return sb.toString();
        }
    }
}
