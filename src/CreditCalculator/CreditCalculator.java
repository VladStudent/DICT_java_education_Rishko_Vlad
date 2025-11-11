package CreditCalculator;

public class CreditCalculator {
    public static void main(String[] args) {

        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String paymentStr = System.getProperty("payment");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

        if (type == null || interestStr == null ||
                (type.equals("diff") && paymentStr != null)) {
            System.out.println("Incorrect parameters");
            return;
        }

        double principal = principalStr != null ? Double.parseDouble(principalStr) : 0;
        double payment = paymentStr != null ? Double.parseDouble(paymentStr) : 0;
        int periods = periodsStr != null ? Integer.parseInt(periodsStr) : 0;
        double interest = Double.parseDouble(interestStr);
        double i = (interest / 100) / 12;

        if (type.equals("diff")) {
            double totalPayment = 0;
            for (int m = 1; m <= periods; m++) {
                double Dm = (principal / periods) + i * (principal - (principal * (m - 1) / periods));
                int rounded = (int) Math.ceil(Dm);
                totalPayment += rounded;
                System.out.println("Month " + m + ": payment is " + rounded);
            }
            System.out.println("Overpayment = " + (int) (totalPayment - principal));
        }

        else if (type.equals("annuity")) {
            if (principalStr == null) {
                double P = payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
                System.out.println("Your loan principal = " + Math.round(P) + "!");
            } else if (paymentStr == null) {
                double A = principal * i * Math.pow(1 + i, periods) / (Math.pow(1 + i, periods) - 1);
                System.out.println("Your annuity payment = " + Math.ceil(A) + "!");
                System.out.println("Overpayment = " + (int) (Math.ceil(A) * periods - principal));
            } else if (periodsStr == null) {
                double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
                int months = (int) Math.ceil(n);
                int years = months / 12;
                int remainMonths = months % 12;
                System.out.print("It will take ");
                if (years > 0) System.out.print(years + (years == 1 ? " year" : " years"));
                if (years > 0 && remainMonths > 0) System.out.print(" and ");
                if (remainMonths > 0) System.out.print(remainMonths + (remainMonths == 1 ? " month" : " months"));
                System.out.println(" to repay this loan!");
                System.out.println("Overpayment = " + (int) (payment * months - principal));
            }
        } else {
            System.out.println("Incorrect parameters");
        }
    }
}
