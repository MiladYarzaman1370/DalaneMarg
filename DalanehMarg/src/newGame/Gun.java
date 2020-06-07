
package newGame;

import dalanehmarg.DalanehMarg;
import dalanehmarg.RandomHelper;

public abstract class Gun {
    
    protected WeaponType weaponType;
    protected int hitRation;
    protected int damage;
    protected BulletCalibr  bulletCalibr;
    private boolean weaponIsZoomIn;
    private int numberOfBullet;
    
    
    Gun() {
        
        bulletCalibr=selectBulletCalibr();
        setNumberOfBullet(DalanehMarg.NumberOfBullet);
        
    }
     private BulletCalibr selectBulletCalibr() {
        int t = 0;
        for (int i = 0; i < 20; i++) {
            t += RandomHelper.nextInt(2);
            
        }
       
        return (t % 2) > 0 ? BulletCalibr.Calibr10mm : BulletCalibr.Calibr5mm;
        
    }
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setBulletCalibr(BulletCalibr bulletCalibr) {
        this.bulletCalibr = bulletCalibr;
    }

    protected void setHitRationAndDamageValue() {
        
                     hitRation=weaponType.getHitRation();
                     damage=weaponType.getDamage();
                      
                     hitRation+=(hitRation*bulletCalibr.EffectOnRate());
                     damage+=bulletCalibr.EffectOnDamage();
      
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getHitRation() {
        return hitRation;
    }

    public int getDamage() {
        return damage;
    }

    public BulletCalibr getBulletCalibr() {
        return bulletCalibr;
    }

    public boolean isWeaponIsZoomIn() {
        return weaponIsZoomIn;
    }

    public int getNumberOfBullet() {
        return numberOfBullet;
    }

    public void setNumberOfBullet(int numberOfBullet) {
        this.numberOfBullet = numberOfBullet;
    }
    
    

    
}
