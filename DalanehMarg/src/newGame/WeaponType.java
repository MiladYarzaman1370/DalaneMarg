
package newGame;

public enum WeaponType {
    assaultRifle(10,50),sniperRifel(20,60);
    private final int damage,hitRation;

    private WeaponType(int damage, int hitRation) {
        this.damage = damage;
        this.hitRation = hitRation;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitRation() {
        return hitRation;
    }
    
}
