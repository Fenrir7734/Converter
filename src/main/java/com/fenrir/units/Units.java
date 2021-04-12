package com.fenrir.units;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class Units {

    private static final MathContext mc = new MathContext(20, RoundingMode.HALF_UP);

    private static final String LENGTH_BASE_UNIT = "m";
    private static final ArrayList<Unit> lengthUnits = new ArrayList<>();

    static {
        lengthUnits.add(new Unit(LENGTH_BASE_UNIT, new BigDecimal("1")));
        lengthUnits.add(new Unit("nm", BigDecimal.TEN.pow(9)));
        lengthUnits.add(new Unit("\u00B5m", BigDecimal.TEN.pow(6)));
        lengthUnits.add(new Unit("mm", BigDecimal.TEN.pow(3)));
        lengthUnits.add(new Unit("cm", BigDecimal.TEN.pow(2)));
        lengthUnits.add(new Unit("dm", BigDecimal.TEN));
        lengthUnits.add(new Unit("km", new BigDecimal("1").divide(BigDecimal.TEN.pow(3), mc)));
        lengthUnits.add(new Unit("in", new BigDecimal("39.3700787")));
        lengthUnits.add(new Unit("ft", new BigDecimal("3.28084")));
        lengthUnits.add(new Unit("yd", new BigDecimal("1").divide(new BigDecimal("0.9144"), mc)));
        lengthUnits.add(new Unit("mile", new BigDecimal("0.000621371192")));
    }

    private static final String AREA_BASE_UNIT = "m" + Unit.SUPERSCRIPT_TWO;
    private final static ArrayList<Unit> areaUnits = new ArrayList<>();

    static {
        areaUnits.add(new Unit(AREA_BASE_UNIT, new BigDecimal("1")));
        areaUnits.add(new Unit("nm" + Unit.SUPERSCRIPT_TWO, BigDecimal.TEN.pow(18)));
        areaUnits.add(new Unit("\u00B5m" + Unit.SUPERSCRIPT_TWO, BigDecimal.TEN.pow(12)));
        areaUnits.add(new Unit("mm" + Unit.SUPERSCRIPT_TWO, BigDecimal.TEN.pow(6)));
        areaUnits.add(new Unit("cm" + Unit.SUPERSCRIPT_TWO, BigDecimal.TEN.pow(4)));
        areaUnits.add(new Unit("dm" + Unit.SUPERSCRIPT_TWO, BigDecimal.TEN.pow(2)));
        areaUnits.add(new Unit("km" + Unit.SUPERSCRIPT_TWO, new BigDecimal("1").divide(BigDecimal.TEN.pow(6), mc)));
        areaUnits.add(new Unit("in" + Unit.SUPERSCRIPT_TWO, new BigDecimal("39.3700787").pow(2)));
        areaUnits.add(new Unit("ft" + Unit.SUPERSCRIPT_TWO, new BigDecimal("3.28084").pow(2)));
        areaUnits.add(new Unit("yd" + Unit.SUPERSCRIPT_TWO, new BigDecimal("1").divide(new BigDecimal("0.9144").pow(2), mc)));
        areaUnits.add(new Unit("mile" + Unit.SUPERSCRIPT_TWO, new BigDecimal("0.000621371192").pow(2)));
        areaUnits.add(new Unit("a", new BigDecimal("0.01")));
        areaUnits.add(new Unit("ha", new BigDecimal("0.0001")));
        areaUnits.add(new Unit("acre", new BigDecimal("0.000247")));
    }

    private static final String VOLUME_BASE_UNIT = "m" + Unit.SUPERSCRIPT_THREE;
    private static final ArrayList<Unit> volumeUnits = new ArrayList<>();

    static {
        volumeUnits.add(new Unit(VOLUME_BASE_UNIT, BigDecimal.TEN.pow(6)));
        volumeUnits.add(new Unit("dl", BigDecimal.TEN.pow(4)));
        volumeUnits.add(new Unit("l", BigDecimal.TEN.pow(3)));
        volumeUnits.add(new Unit("hl", BigDecimal.TEN));
        volumeUnits.add(new Unit("m" + Unit.SUPERSCRIPT_THREE, BigDecimal.ONE));
        volumeUnits.add(new Unit("mm" + Unit.SUPERSCRIPT_THREE, BigDecimal.TEN.pow(9)));
        volumeUnits.add(new Unit("cm" + Unit.SUPERSCRIPT_THREE, BigDecimal.TEN.pow(6)));
        volumeUnits.add(new Unit("dm" + Unit.SUPERSCRIPT_THREE, BigDecimal.TEN.pow(3)));
        volumeUnits.add(new Unit("in" + Unit.SUPERSCRIPT_THREE, new BigDecimal("61023.7441")));
        volumeUnits.add(new Unit("ft" + Unit.SUPERSCRIPT_THREE, new BigDecimal("35.3146667")));
        volumeUnits.add(new Unit("yd" + Unit.SUPERSCRIPT_THREE, new BigDecimal("1.30795062")));
        volumeUnits.add(new Unit("gal (UK)", new BigDecimal("219.969248")));
        volumeUnits.add(new Unit("gal (US)", new BigDecimal("264.172052")));
        volumeUnits.add(new Unit("bbl", new BigDecimal("6.289814")));
        volumeUnits.add(new Unit("pt (UK)", new BigDecimal("1759.75399")));
        volumeUnits.add(new Unit("pt (US)", new BigDecimal("2113.37642")));
    }

    private static final String WEIGHT_BASE_UNIT = "g";
    private static final ArrayList<Unit> weightUnits = new ArrayList<>();

    static {
        weightUnits.add(new Unit(WEIGHT_BASE_UNIT, new BigDecimal("1")));
        weightUnits.add(new Unit("\u00B5g", BigDecimal.TEN.pow(6)));
        weightUnits.add(new Unit("mg", new BigDecimal("1000")));
        weightUnits.add(new Unit("dag", new BigDecimal("0.1")));
        weightUnits.add(new Unit("kg", new BigDecimal("0.001")));
        weightUnits.add(new Unit("oz", new BigDecimal("0.0352739619")));
        weightUnits.add(new Unit("lb", new BigDecimal("0.00220462262")));
        weightUnits.add(new Unit("grain", new BigDecimal("15.4323584")));
        weightUnits.add(new Unit("stone", new BigDecimal("0.000157473")));
        weightUnits.add(new Unit("carats", new BigDecimal("5")));
        weightUnits.add(new Unit("slug", new BigDecimal("6.85217659").divide(BigDecimal.TEN.pow(5), mc)));
        weightUnits.add(new Unit("tonne", BigDecimal.ONE.divide(BigDecimal.TEN.pow(6), mc)));
        weightUnits.add(new Unit("ton (UK) long", new BigDecimal("0.00000098")));
        weightUnits.add(new Unit("ton (US) short", new BigDecimal("0.000001102")));
    }

    private static final String TIME_BASE_UNIT = "sec";
    private static final ArrayList<Unit> timeUnits = new ArrayList<>();

    static {
        timeUnits.add(new Unit(TIME_BASE_UNIT, BigDecimal.ONE));
        timeUnits.add(new Unit("ms", new BigDecimal("1000")));
        timeUnits.add(new Unit("min", new BigDecimal("0.0166666667")));
        timeUnits.add(new Unit("hour", new BigDecimal("0.000277777778")));
        timeUnits.add(new Unit("day", new BigDecimal("1.15740741").divide(BigDecimal.TEN.pow(5), mc)));
        timeUnits.add(new Unit("week", new BigDecimal("1.65343915").divide(BigDecimal.TEN.pow(6), mc)));
        timeUnits.add(new Unit("month", new BigDecimal("3.80265176").divide(BigDecimal.TEN.pow(7), mc)));
        timeUnits.add(new Unit("year", new BigDecimal("3.16887646").divide(BigDecimal.TEN.pow(8), mc)));
    }

    private static final String SPEED_BASE_UNIT = "m/s";
    private static final ArrayList<Unit> speedUnits = new ArrayList<>();

    static { //add Beaufort
        speedUnits.add(new Unit(SPEED_BASE_UNIT, BigDecimal.ONE));
        speedUnits.add(new Unit("m/min", new BigDecimal("60")));
        speedUnits.add(new Unit("km/s", new BigDecimal("0.001")));
        speedUnits.add(new Unit("km/min", new BigDecimal("0.06")));
        speedUnits.add(new Unit("km/h", new BigDecimal("3.6")));
        speedUnits.add(new Unit("ft/s", new BigDecimal("3.2808399")));
        speedUnits.add(new Unit("ft/min", new BigDecimal("196.850394")));
        speedUnits.add(new Unit("mph", new BigDecimal("2.23693629")));
        speedUnits.add(new Unit("knot", new BigDecimal("1.94384449")));
        speedUnits.add(new Unit("mach", new BigDecimal("0.0029386699")));
    }

    private static final String PRESSURE_BASE_UNIT = "Pa";
    private static final ArrayList<Unit> pressureUnits = new ArrayList<>();

    static {
        pressureUnits.add(new Unit(PRESSURE_BASE_UNIT, BigDecimal.ONE));
        pressureUnits.add(new Unit("atm", new BigDecimal("0.00000986923")));
        pressureUnits.add(new Unit("hPa", new BigDecimal("0.01")));
        pressureUnits.add(new Unit("kPa", new BigDecimal("0.001")));
        pressureUnits.add(new Unit("MPa", new BigDecimal("0.000001")));
        pressureUnits.add(new Unit("bar", new BigDecimal("0.00001")));
        pressureUnits.add(new Unit("psi", new BigDecimal("0.000145037738")));
        pressureUnits.add(new Unit("psf", new BigDecimal("0.020885434273039")));
        pressureUnits.add(new Unit("ksi", new BigDecimal("1.4503773800722E-7")));
        pressureUnits.add(new Unit("mmHg", new BigDecimal("0.00750061683")));
        pressureUnits.add(new Unit("cmHg", new BigDecimal("0.00075006156130264")));
        pressureUnits.add(new Unit("mmH" + Unit.SUBSCRIPT_TWO + "O", new BigDecimal("0.10197162129779")));
        pressureUnits.add(new Unit("cmH" + Unit.SUBSCRIPT_TWO + "O", new BigDecimal("0.010197162129779")));
        pressureUnits.add(new Unit("inchH" + Unit.SUBSCRIPT_TWO + "O", new BigDecimal("0.0040146307866177")));
        pressureUnits.add(new Unit("kgf/mm" + Unit.SUBSCRIPT_TWO, new BigDecimal("1.0197162129779E-7")));
        pressureUnits.add(new Unit("kgf/cm" + Unit.SUPERSCRIPT_TWO, new BigDecimal("0.000010197")));
        pressureUnits.add(new Unit("kgf/m" + Unit.SUPERSCRIPT_TWO, new BigDecimal("0.10197162129779")));
        pressureUnits.add(new Unit("mTorr", new BigDecimal("7.5006167382113")));
    }

    private static final String FORCE_BASE_UNIT = "N";
    private static final ArrayList<Unit> forceUnit = new ArrayList<>();

    static {
        forceUnit.add(new Unit(FORCE_BASE_UNIT, BigDecimal.ONE));
        forceUnit.add(new Unit("dyn", new BigDecimal("100000")));
        forceUnit.add(new Unit("mN", new BigDecimal("1000")));
        forceUnit.add(new Unit("daN", new BigDecimal("0.1")));
        forceUnit.add(new Unit("kN", new BigDecimal("0.001")));
        forceUnit.add(new Unit("kgf", new BigDecimal("0.101971621308191")));
        forceUnit.add(new Unit("lbf", new BigDecimal("0.22480894387096")));
        forceUnit.add(new Unit("kip", new BigDecimal("2.248089438709618E-4")));
    }

    private static final String WORK_BASE_UNIT = "J";
    private static final ArrayList<Unit> workUnits = new ArrayList<>();

    static {
        workUnits.add(new Unit(WORK_BASE_UNIT, BigDecimal.ONE));
        workUnits.add(new Unit("kJ", new BigDecimal("0.001")));
        workUnits.add(new Unit("cal", new BigDecimal("0.23883448770002")));
        workUnits.add(new Unit("kcal", new BigDecimal("0.0002388458966275")));
        workUnits.add(new Unit("Ws", BigDecimal.ONE));
        workUnits.add(new Unit("Wh", BigDecimal.ONE.divide(new BigDecimal("3600"), mc)));
        workUnits.add(new Unit("kWh", BigDecimal.ONE.divide(new BigDecimal("3600000"), mc)));
        workUnits.add(new Unit("MWh", BigDecimal.ONE.divide(new BigDecimal("3600000000"), mc)));
        //workUnits.add(new Unit("GeV", new BigDecimal("6241509647.1204")));
        //workUnits.add(new Unit("TeV", new BigDecimal("6241509.6471204")));
        //workUnits.add(new Unit("MeV", new BigDecimal("6241509647120.4")));
        //workUnits.add(new Unit("keV", new BigDecimal("6.2415096471204E+15")));
        //workUnits.add(new Unit("eV", new BigDecimal("6.2415096471204E+18")));
        workUnits.add(new Unit("kgf" + Unit.MULTIPLICATION_DOT + "m", new BigDecimal("0.101971621300936")));
        workUnits.add(new Unit("in" + Unit.MULTIPLICATION_DOT + "lbf", new BigDecimal("8.850745")));
        workUnits.add(new Unit("ft" + Unit.MULTIPLICATION_DOT + "lbf", new BigDecimal("0.73756214927727")));
        workUnits.add(new Unit("BTU", new BigDecimal("0.0009478171")));
        workUnits.add(new Unit("toe", new BigDecimal("2.388458966275E-11")));
    }

    private static final String POWER_BASE_UNIT = "W";
    private static final ArrayList<Unit> powerUnits = new ArrayList<>();

    static {
        powerUnits.add(new Unit(POWER_BASE_UNIT, BigDecimal.ONE));
        powerUnits.add(new Unit("kW", new BigDecimal("0.001")));
        powerUnits.add(new Unit("MW", new BigDecimal("0.000001")));
        powerUnits.add(new Unit("kcal/s", new BigDecimal("0.000239005736")));
        powerUnits.add(new Unit("kcal/h", new BigDecimal("0.859845227859")));
        powerUnits.add(new Unit("HP", new BigDecimal("0.00134102209")));
        powerUnits.add(new Unit("KM", new BigDecimal("0.001359634733")));
        powerUnits.add(new Unit("BTU/h", new BigDecimal("3.412141633")));
        powerUnits.add(new Unit("TR", new BigDecimal("0.0002845354")));
        //powerUnits.add(new Unit("dBm", new BigDecimal("30")));
    }

    private static final String ANGLE_BASE_UNIT = "deg (" + Unit.DEGREE + ")";
    private static final ArrayList<Unit> angleUnits = new ArrayList<>();

    static {
        angleUnits.add(new Unit(ANGLE_BASE_UNIT, BigDecimal.ONE));
        angleUnits.add(new Unit("rad", new BigDecimal("0.0174532925")));
        angleUnits.add(new Unit("min (')", new BigDecimal("60")));
        angleUnits.add(new Unit("sec ('')", new BigDecimal("3600")));
        angleUnits.add(new Unit("grad", new BigDecimal("1.1111111111111")));
        angleUnits.add(new Unit("circle", new BigDecimal("0.0027777777777778")));
    }

    private static final String DATA_BASE_UNIT = "bit";
    private static final ArrayList<Unit> dataUnits = new ArrayList<>();

    static {
        dataUnits.add(new Unit(DATA_BASE_UNIT, BigDecimal.ONE));
        dataUnits.add(new Unit("Byte", new BigDecimal("0.125")));
        dataUnits.add(new Unit("kB", new BigDecimal("0.000125")));
        dataUnits.add(new Unit("KiB", new BigDecimal("0.000122070312")));
        dataUnits.add(new Unit("MiB", new BigDecimal("9.5367431640625E-7").divide(new BigDecimal("8"), mc)));
        dataUnits.add(new Unit("GiB", new BigDecimal("9.3132257461548E-10").divide(new BigDecimal("8"), mc)));
        dataUnits.add(new Unit("TiB", new BigDecimal("9.0949470177293E-13").divide(new BigDecimal("8"), mc)));
        dataUnits.add(new Unit("kbit/s", new BigDecimal("0.001")));
        dataUnits.add(new Unit("Mbit/s", new BigDecimal("0.000001")));
        dataUnits.add(new Unit("Gbit/s", new BigDecimal("1.0E-9")));
    }

    private static final String FUEL_BASE_UNIT = "km/l";
    private static final ArrayList<Unit> fuelUnits = new ArrayList<>();

    static {
        fuelUnits.add(new Unit(FUEL_BASE_UNIT, BigDecimal.ONE));
        fuelUnits.add(new Unit("mi/l", new BigDecimal("0.621371192")));
        fuelUnits.add(new Unit("km/gal (US)", new BigDecimal("3.78541178")));
        fuelUnits.add(new Unit("km/gal (UK)", new BigDecimal("4.54609188")));
        fuelUnits.add(new Unit("mi/gal (US)", new BigDecimal("2.352145833")));
        fuelUnits.add(new Unit("mi/gal (UK)", new BigDecimal("2.824809363")));
    }

    private static final String COOKING_BASE_UNIT = "ml";
    private static final ArrayList<Unit> cookingUnits = new ArrayList<>();

    static {
        cookingUnits.add(new Unit(COOKING_BASE_UNIT, BigDecimal.ONE));
        cookingUnits.add(new Unit("teaspoon", new BigDecimal("0.202884136")));
        cookingUnits.add(new Unit("tablespoon", new BigDecimal("0.0676280454")));
        cookingUnits.add(new Unit("cup (US)", new BigDecimal("0.00422675284")));
        cookingUnits.add(new Unit("cup (UK)", new BigDecimal("0.0035195079727854")));
        cookingUnits.add(new Unit("cup (metric)", new BigDecimal("0.004")));
        cookingUnits.add(new Unit("fl oz (US)", new BigDecimal("0.0338140233449988")));
        cookingUnits.add(new Unit("fl oz (UK)", new BigDecimal("0.0351950797")));
        cookingUnits.add(new Unit("pt (US)", new BigDecimal("0.0021133764188652")));
        cookingUnits.add(new Unit("pt (UK)", new BigDecimal("0.0017597539863927")));
    }

    private static final String TEMPERATURE_BASE_UNIT = Unit.DEGREE + "C";
    private static final ArrayList<Unit> temperatureUnits = new ArrayList<>();

    static {
        temperatureUnits.add(new Unit(TEMPERATURE_BASE_UNIT));
        temperatureUnits.add(new Unit(Unit.DEGREE + "F"));
        temperatureUnits.add(new Unit("K"));
        temperatureUnits.add(new Unit(Unit.DEGREE + "R"));
        temperatureUnits.add(new Unit(Unit.DEGREE + "Re"));
    }

    private static final String PREFIXES_BASE= "";
    private static final ArrayList<Unit> prefixes = new ArrayList<>();

    static {
        prefixes.add(new Unit(PREFIXES_BASE, BigDecimal.ONE));
        prefixes.add(new Unit("yotta", BigDecimal.TEN.pow(-24, mc)));
        prefixes.add(new Unit("zetta", BigDecimal.TEN.pow(-21, mc)));
        prefixes.add(new Unit("exa", BigDecimal.TEN.pow(-18, mc)));
        prefixes.add(new Unit("peta", BigDecimal.TEN.pow(-15, mc)));
        prefixes.add(new Unit("tera", BigDecimal.TEN.pow(-12, mc)));
        prefixes.add(new Unit("giga", BigDecimal.TEN.pow(-9, mc)));
        prefixes.add(new Unit("mega", BigDecimal.TEN.pow(-6, mc)));
        prefixes.add(new Unit("kilo", BigDecimal.TEN.pow(-3, mc)));
        prefixes.add(new Unit("hecto", BigDecimal.TEN.pow(-2, mc)));
        prefixes.add(new Unit("deca", BigDecimal.TEN.pow(-1,mc)));
        prefixes.add(new Unit("deci", BigDecimal.TEN.pow(1)));
        prefixes.add(new Unit("centi", BigDecimal.TEN.pow(2)));
        prefixes.add(new Unit("milli", BigDecimal.TEN.pow(3)));
        prefixes.add(new Unit("micro", BigDecimal.TEN.pow(6)));
        prefixes.add(new Unit("nano", BigDecimal.TEN.pow(9)));
        prefixes.add(new Unit("pico", BigDecimal.TEN.pow(12)));
        prefixes.add(new Unit("femto", BigDecimal.TEN.pow(15)));
        prefixes.add(new Unit("atto", BigDecimal.TEN.pow(18)));
        prefixes.add(new Unit("zepto", BigDecimal.TEN.pow(21)));
        prefixes.add(new Unit("yocto", BigDecimal.TEN.pow(24)));
    }

    public static final HashMap<UnitsCategory, ArrayList<Unit>> allUnits = new HashMap<>();

    static {
        allUnits.put(UnitsCategory.LENGTH, lengthUnits);
        allUnits.put(UnitsCategory.AREA, areaUnits);
        allUnits.put(UnitsCategory.WEIGHT, weightUnits);
        allUnits.put(UnitsCategory.VOLUME, volumeUnits);
        allUnits.put(UnitsCategory.TEMPERATURE, temperatureUnits);
        allUnits.put(UnitsCategory.TIME, timeUnits);
        allUnits.put(UnitsCategory.SPEED, speedUnits);
        allUnits.put(UnitsCategory.PRESSURE, pressureUnits);
        allUnits.put(UnitsCategory.FORCE, forceUnit);
        allUnits.put(UnitsCategory.WORK, workUnits);
        allUnits.put(UnitsCategory.POWER, powerUnits);
        allUnits.put(UnitsCategory.ANGLE, angleUnits);
        allUnits.put(UnitsCategory.DATA, dataUnits);
        allUnits.put(UnitsCategory.FUEL, fuelUnits);
        allUnits.put(UnitsCategory.COOKING, cookingUnits);
        allUnits.put(UnitsCategory.PREFIXES, prefixes);
    }

    public static final HashMap<UnitsCategory, String> allBaseUnit = new HashMap<>();

    static {
        allBaseUnit.put(UnitsCategory.LENGTH, LENGTH_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.AREA, AREA_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.WEIGHT, WEIGHT_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.VOLUME, VOLUME_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.TEMPERATURE, TEMPERATURE_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.TIME, TIME_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.SPEED, SPEED_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.PRESSURE, PRESSURE_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.FORCE, FORCE_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.WORK, WORK_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.POWER, POWER_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.ANGLE, ANGLE_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.DATA, DATA_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.FUEL, FUEL_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.COOKING, COOKING_BASE_UNIT);
        allBaseUnit.put(UnitsCategory.PREFIXES, PREFIXES_BASE);
    }

}