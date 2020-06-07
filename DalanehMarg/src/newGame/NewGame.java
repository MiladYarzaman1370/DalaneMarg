
package newGame;

import dalanehmarg.DalanehMarg;
import dalanehmarg.RandomHelper;
import java.util.ArrayList;

public class NewGame {
   private final int numberOfGroupsMember;
   private ArrayList<Soldier> groupA;
    private ArrayList<Soldier> groupB;
    Soldier championA,championB;
    private int indexChampionFromGroupA;
    private int indexChampionFromGroupB;
    public static int tempForIndex=5555;

    public NewGame(int width) {
        this.numberOfGroupsMember = width;
        //////////////////////////////////////////temp valu for check...
        indexChampionFromGroupA=tempForIndex;
        indexChampionFromGroupB=tempForIndex;
        creatGroup();
        startMatchs();
          //System.out.println("groupA: "+groupA.size());
           //  System.out.println("groupB: "+groupB.size());
    }


    private void creatGroup() {
        groupA=new ArrayList<>();
        groupB=new ArrayList<>();
        Soldier s;
        for(int i=0;i<numberOfGroupsMember;i++)
        {
             s=new Soldier(i);
             groupA.add(s);
             
             s=new Soldier(i);
             groupB.add(s);
            
        }
    }

    private void startMatchs() {
        int temp;
        while(groupA.size()>0&&groupB.size()>0)
        {
            if(indexChampionFromGroupA==tempForIndex)
            {
              temp=  RandomHelper.nextInt(groupA.size());
             indexChampionFromGroupA=temp;
            }
                
             championA=groupA.get(indexChampionFromGroupA);
             if(indexChampionFromGroupB==tempForIndex){
                 temp=RandomHelper.nextInt(groupB.size());
            indexChampionFromGroupB=temp;
           
             }
                
             championB=groupB.get(indexChampionFromGroupB);
             System.out.println("//////////////////////////\nA vs B:    id= "+championA.getId()+" -  id="+championB.getId());
             startFight();
             
              championA.getGun().setNumberOfBullet(DalanehMarg.NumberOfBullet);
              championB.getGun().setNumberOfBullet(DalanehMarg.NumberOfBullet);
            System.out.println("groupA: "+groupA.size());
             System.out.println("groupB: "+groupB.size());
             
        }
    }

    private void startFight() {
         System.out.println("getGunType     A: "+championA.getGun().getWeaponType()+"  B: "+championB.getGun().getWeaponType());
            System.out.println("getBulletCalibr     A: "+championA.getGun().getBulletCalibr()+"  B: "+championB.getGun().getBulletCalibr());
            System.out.println("getHitRation     A: "+championA.getGun().getHitRation()+"  B: "+championB.getGun().getHitRation());
           
        while(championA.getGun().getNumberOfBullet()>0
                &&championB.getGun().getNumberOfBullet()>0
                &&championA.getStamina()>0&&championB.getStamina()>0)
        {
           
            championA.attack(championB);
            if(championB.getStamina()<=0)
            {
                groupB.remove(indexChampionFromGroupB);
                indexChampionFromGroupB=tempForIndex;
                 System.out.println("**********Shuting and Deads\ngetStamina       A: "+championA.getStamina()+"  B: "+championB.getStamina());
            System.out.println("getNumberOfBullet     A: "+championA.getGun().getNumberOfBullet()+"  B: "+championB.getGun().getNumberOfBullet());
           
                System.out.println("B deads");
                break;
            }
            else
            {}
            championB.attack(championA);
            if(championA.getStamina()<=0)
            {
                groupA.remove(indexChampionFromGroupA);
                indexChampionFromGroupA=tempForIndex;
                 System.out.println("**********Shuting with Dead\ngetStamina       A: "+championA.getStamina()+"  B: "+championB.getStamina());
                 System.out.println("getNumberOfBullet     A: "+championA.getGun().getNumberOfBullet()+"  B: "+championB.getGun().getNumberOfBullet());
           
                System.out.println("A deads");
                break;
            }
            else
            {}
             System.out.println("****/////******Shuting withOut Dead\ngetStamina       A: "+championA.getStamina()+"  B: "+championB.getStamina());
            System.out.println("getNumberOfBullet     A: "+championA.getGun().getNumberOfBullet()+"  B: "+championB.getGun().getNumberOfBullet());
           
        }
    }
        
}
