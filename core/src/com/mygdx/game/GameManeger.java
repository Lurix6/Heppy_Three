package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

import java.util.Random;


public class GameManeger {
    private int positionAddNew;
    private Random r = new Random();
    private ArrayList<Animation> listAnimations = new ArrayList<Animation>();
    private ArrayList<AttackLend> attackLends = new ArrayList<AttackLend>();
    private ArrayList<GunInGame> actualGuns = new ArrayList<GunInGame>();
    private ArrayList<MenuGans> menuGuns = new ArrayList<MenuGans>();
    private SpriteBatch batch;
//    private TextInGame textInGame;
    private GameMap map;
    private int howYouKill = 0;
    Rectangle mouseRectangle;


    public GameManeger(SpriteBatch batch) {
        this.batch = batch;
//        textInGame = new TextInGame(batch);
        map = new GameMap(batch);
    }

    public void render(SpriteBatch batch){
        map.render();
        for (int i = 0; i < actualGuns.size(); i++) {
            actualGuns.get(i).render(batch);
        }
        for (int i = 0; i < listAnimations.size(); i++) {
            listAnimations.get(i).render(batch);
        }
        for (int i = 0; i < menuGuns.size(); i++) {
            menuGuns.get(i).render(batch);
        }
        for (int i = 0; i < attackLends.size(); i++) {
            attackLends.get(i).render(batch);
        }
        update();
    }
    public void update(){
        for (int i = 0; i < listAnimations.size(); i++) {
            if (attackLends.get(listAnimations.get(i).getPath()).isLandIsFree() == false) {
                attackLends.get(listAnimations.get(i).getPath()).setAttack(true);
            }
            /*
                      Видалити анімацю яка дійшла 0
                  */
            if (listAnimations.get(i).getX() < 0){
                listAnimations.remove(listAnimations.get(i));
                attackLends.get(listAnimations.get(i).getPath()).setDeleteBullet(true);
                howYouKill++;
                createPerson(1);

            }
            if (listAnimations.get(i).getRectangleAnimation().contains(attackLends.get(listAnimations.get(i).getPath()).getBulletRectangle())){
                listAnimations.remove(listAnimations.get(i));
                createPerson(1);
                howYouKill++;
            }

           else if (InputHandlet.mousClik()) {
                mouseRectangle = new com.badlogic.gdx.math.Rectangle(InputHandlet.getMousePositionX(),InputHandlet.getMousePositionY(),1,1);

                if (listAnimations.get(i).getRectangleAnimation().contains(mouseRectangle)){
                        listAnimations.remove(listAnimations.get(i));
                        howYouKill++;
                        if (howYouKill > 3 && howYouKill < 20){
                            createPerson(r.nextInt(howYouKill/4)+1);
                        }else if (howYouKill > 20) {
                            createPerson(r.nextInt(howYouKill/10)+1);
                        }else{
                            createPerson(1);
                        }
                }
            }
        }

        for (int i = 0; i < menuGuns.size(); i++) {
            if (InputHandlet.mousClik()) {
                mouseRectangle = new com.badlogic.gdx.math.Rectangle(InputHandlet.getMousePositionX(),InputHandlet.getMousePositionY(),1,1);
                if (menuGuns.get(i).getMyRectangle().contains(mouseRectangle)){
                    menuGuns.get(i).setActive(false);
                }else if (menuGuns.get(i).isActive() == false ){
                    for (int j = 0; j < attackLends.size(); j++) {
                        if (attackLends.get(j).getRectangle().contains(mouseRectangle)) {
                            menuGuns.get(i).setActive(true);
                            attackLends.get(j).setX(0,j*60);
                            attackLends.get(j).setLandIsFree(false);

                        }
                    }
                }
            }
        }
    }


    public void crete(){
        createPerson(1);
        fillGunsMenu();
        fillAttackLads();

    }


    private void fillGunsMenu(){
        menuGuns.add(new MenuGans(new Texture("guns.png"),10 ,530));
    }
    private void createPerson(int howMach){

        for (int i = 0; i < howMach; i++) {
            listAnimations.add(new Animation(new Texture(Res.heroes[r.nextInt(5)]) ,r.nextInt(7)));
            positionAddNew = r.nextInt(600)+400;

        }
    }
    private void fillAttackLads(){
        for (int i = 0; i < 7; i++) {
            attackLends.add(new AttackLend(new Rectangle(0,i*60, 130,60)));
        }
    }

}
