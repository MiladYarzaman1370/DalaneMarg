package newGame;

import dalanehmarg.RandomHelper;

public class Soldier {

    private int id;
    private int stamina;
  //  private Weapon weapon;
    private Gun gun;

    public Soldier(int id) {
        this.id = id;
        this.stamina = 100;
        WeaponType wType = selectWeapon();
        switch(wType)
        {
            case assaultRifle:
                gun=new AssaultRiple();
                break;
            case sniperRifel:
                gun=new SniperRiple();
                break;
            default:
        }
        
        
    }

    private WeaponType selectWeapon() {
        int t = 0;
        for (int i = 0; i < 20; i++) {
            t += RandomHelper.nextInt(2);
        }
        return (t % 2) > 0 ? WeaponType.assaultRifle : WeaponType.sniperRifel;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }


    public void attack(Soldier enemy) {
        ////////////////////if The shot is successful
        if (checkShot()) {
            enemy.setStamina(enemy.getStamina() - this.gun.getDamage());

        }
        this.gun.setNumberOfBullet(this.gun.getNumberOfBullet() - 1);
        // System.err.println("attack");

    }

    private boolean checkShot() {

        // System.out.println(""+(100-this.weapon.getHitRation()));
        int[] hitRatErr = new int[100 - this.gun.getHitRation()];

        int temp;
        for (int i = 0; i < hitRatErr.length; i++) {
            temp = RandomHelper.nextInt(100) + 1;
            if (!check(hitRatErr, temp)) {
                hitRatErr[i] = temp;
            } else {
                i--;
            }
        }
        temp = RandomHelper.nextInt(100) + 1;
        if (!check(hitRatErr, temp)) {
            return false;
        } else {
            return true;
        }

    }

    private boolean check(int[] arr, int toCheckValue) {
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                return test;
            }
        }
        return test;
    }
}
