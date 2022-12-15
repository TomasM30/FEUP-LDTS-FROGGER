package com.aor.frogger.model.arena;

import com.aor.frogger.model.Car;
import com.aor.frogger.model.Frog;
import com.aor.frogger.model.Leaf;
import com.aor.frogger.model.Log;
import com.aor.frogger.model.game.Dirt;
import com.aor.frogger.model.game.River;
import com.aor.frogger.model.game.Road;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final String level;
    private final List<String> lines;

    public LoaderArenaBuilder(String level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level.lvl"); // mudar isto
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for(int j = 0;j<lines.size() ; j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i) == 'C') cars.add(new Car(i,j));
            }
        }
        return cars;
    }

    @Override
    protected Frog createFrog() {
        for (int j = 0; j < lines.size(); j++) {
            String line = lines.get(j);
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'H') return new Frog(i, j, 3);
            }
        }
        return null;
    }

    @Override
    protected List<Log> createLogs() {
        List<Log> logs = new ArrayList<>();
        for(int j = 0; j<lines.size(); j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i)=='L') logs.add(new Log(i,j));
            }
        }
        return logs;
    }

    @Override
    protected List<Leaf> createLeaves() {
        List<Leaf> leaves = new ArrayList<>();
        for(int j = 0; j<lines.size(); j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i)=='@') leaves.add(new Leaf(i,j));
            }
        }
        return leaves;
    }

    @Override
    protected List<Road> createRoads() {
        List<Road> roads = new ArrayList<>();
        for(int j = 0; j<lines.size(); j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i)=='#') roads.add(new Road(i,j));
            }
        }
        return roads;
    }
    @Override
    protected List<Dirt> createDirt() {
        List<Dirt> dirts = new ArrayList<>();
        for(int j = 0; j<lines.size(); j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i)=='%') dirts.add(new Dirt(i,j));
            }
        }
        return dirts;
    }

    @Override
    protected List<River> createRivers() {
        List<River> rivers = new ArrayList<>();
        for(int j = 0; j<lines.size(); j++) {
            String line = lines.get(j);
            for(int i = 0; i<line.length(); i++) {
                if(line.charAt(i)=='-') rivers.add(new River(i,j));
            }
        }
        return rivers;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<List<Object>> getLines() {return null;}

    @Override
    protected List<List<Object>> createLines(){
        List<List<Object>> linhas = new ArrayList<>();
        for(int i = 0; i<lines.size();i++){
            linhas.add(new ArrayList<>());
        }
        for(int j = lines.size()-1; j>=0; j--) {
            String line = lines.get(j);
            if (j == lines.size()-1) {
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == 'H') linhas.get(j).add(new Frog(i,j,3));
                    else linhas.get(j).add(new Dirt(i,j));
                }
                continue;
            }
            if(j == lines.size()/2) {
                for(int i = 0; i<line.length(); i++) {
                    linhas.get(j).add(new Dirt(i,j));
                }
                continue;
            }
            if(j == 0) {
                for(int i = 0; i<line.length(); i++) {
                    linhas.get(j).add(new Dirt(i, j));
                }
                continue;
            }
            if(j>lines.size()/2) {
                for(int i = 0; i<line.length(); i++) {
                    if(line.charAt(i) == 'C') linhas.get(j).add(new Car(i,j));
                    else linhas.get(j).add(new Road(i,j));
                }
                continue;
            }
            if(j<lines.size()/2) {
                for(int i = 0; i<line.length(); i++) {
                    if(line.charAt(i) == 'L'){
                        linhas.get(j).add(new Log(i,j));
                    }
                    else if(line.charAt(i) == '@') {
                        linhas.get(j).add(new Leaf(i,j));

                    }
                    else linhas.get(j).add(new River(i,j));
                }
            }
        }
        return linhas;
    }
}
