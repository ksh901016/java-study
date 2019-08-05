package stream.collect.custom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyCollect {
    public static void main(String[] args) {
        // id가 같은 class를 하나의 class로 변환해서 mapping 하여야함.

        List<Company> companyList = Arrays.asList(new Company("1", "1"), new Company("2", "2"), new Company("3", "3"));
        List<AnotherCompany> anotherCompanyList = Arrays.asList(new AnotherCompany("2", "2"), new AnotherCompany("3", "3"), new AnotherCompany("5", "5"));

        // 첫번째 방법
        List<AnotherCompany> result =
        companyList.stream()
                .filter(company -> anotherCompanyList.stream().anyMatch(anotherCompany -> anotherCompany.getId().equals(company.getId())))
                .map(company -> {
                    AnotherCompany anotherCompany = new AnotherCompany(company.getId(), company.getName());
                    return anotherCompany;
                })
                .collect(Collectors.toList());

        result.stream().forEach(System.out::println);

        // 두번째 방법
        // 집에가서 해보자
    }
}
