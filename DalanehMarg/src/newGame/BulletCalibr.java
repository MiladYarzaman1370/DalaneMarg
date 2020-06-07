package newGame;


public enum BulletCalibr {
    Calibr10mm(-10,10),Calibr5mm(15,0);

    private BulletCalibr(int EffectOnRate,int EffectOnDamage) {
        this.EffectOnRate = EffectOnRate;
        this.EffectOnDamage=EffectOnDamage;
        //System.out.println("this.EffectOnRate:"+ this.EffectOnRate);
    }
    private final float EffectOnRate;
            private int EffectOnDamage;
    public float EffectOnRate()
    {   
       // System.out.println("this.EffectOnRate/100: "+ this.EffectOnRate/100);
        return this.EffectOnRate/100;}
    public int EffectOnDamage()
    {
        return this.EffectOnDamage;
    }
    
}
