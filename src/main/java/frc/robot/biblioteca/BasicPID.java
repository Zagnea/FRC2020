package frc.robot.biblioteca;

public class BasicPID {
    private double m_P;
    private double m_I;
    private double m_D;
    private double m_errorSum;
    private double m_error;
    private double m_maxError;
    private double m_maxOutput;
    private double m_minOutput;
    private double m_lastPosition;
    private double m_target;
    private double m_position;

    public double getTarget() { return m_target; }
    public double getPosition(){return m_position;}
    public double getP() { return m_P; }
    public double getI() { return m_I; }
    public double getD() { return m_D; }

    public void setTarget(double target) {m_target = target;}
    public void setPosition(double position) {
        m_lastPosition = position;
        m_position = position; 
    }
    public void setP(double P) { m_P = P; }
    public void setI(double I) { m_I = I; }
    public void setD(double D) { m_D = D; }
    public void setMinOutput(double min) { m_minOutput = min; }
    public void setMaxOutput(double max) { m_maxOutput = max; }

    public double calculateError() {
        double output = 0;
        m_error = m_target - m_position;
        m_errorSum += m_error;
        output += m_error * m_P;
        output += m_errorSum * m_I;
        output -= m_error - m_lastPosition * m_D;
        if(m_errorSum > m_maxError) {
            m_errorSum = m_maxError;
        }
        if(output > m_maxOutput){
            output = m_maxOutput;
        }
        if(output < m_minOutput){
            output = m_minOutput;
        }
        return output;
    }
}

