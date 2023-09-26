package database.models;


import java.time.LocalDateTime;
import java.util.Objects;

public class Domain {
    public Integer id;
    public String webName;
    public String domainName;
    public String ip;
    public LocalDateTime dateReg;
    public String countryReg;
    public Integer personId;

    public Domain(Integer id, String webName, String domainName, String ip, LocalDateTime dateReg, String countryReg, Integer personId) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dateReg = dateReg;
        this.countryReg = countryReg;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public String getWebName() {
        return webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getDateReg() {
        return dateReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public Integer getPersonId() {
        return personId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(webName, domain.webName) && Objects.equals(domainName, domain.domainName) && Objects.equals(ip, domain.ip) && Objects.equals(dateReg, domain.dateReg) && Objects.equals(countryReg, domain.countryReg) && Objects.equals(personId, domain.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webName, domainName, ip, dateReg, countryReg, personId);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", webName='" + webName + '\'' +
                ", domainName='" + domainName + '\'' +
                ", ip='" + ip + '\'' +
                ", dateReg=" + dateReg +
                ", countryReg='" + countryReg + '\'' +
                ", personId=" + personId +
                '}';
    }

}
