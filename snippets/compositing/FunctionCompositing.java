Function<Double, Double> log = (value) -> Math.log(value);
Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
Function<Double, Double> logThenSqrt = sqrt.compose(log);
logger.log(Level.INFO, String.valueOf(logThenSqrt.apply(3.14)));
// Output: 1.06

Function<Double, Double> sqrtThenLog = sqrt.andThen(log);
logger.log(Level.INFO, String.valueOf(sqrtThenLog.apply(3.14)));
// Output: 0.57