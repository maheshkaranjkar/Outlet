package com.unilever.outlet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.unilever.outlet.Dao.OutletDao;
import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.service.OutletService;

@SpringBootTest
class OutletApplicationTests {

	/*@Autowired
	private MockMvc mockMvc;*/
	
	@Mock
	private OutletDao outletDao;
	
	@InjectMocks
	private OutletService outletService;
	
	List<Outlet> outletsTestUnique =  new ArrayList<Outlet>();
	
	List<Outlet> outletsTestNotNull =  new ArrayList<Outlet>();
	
	
	@BeforeEach
	void setup() {
		Outlet outlet = new Outlet();
		outlet.setId(1);
		outlet.setLastName("TestName");
		outlet.setLocation("TestLocation");
		outlet.setOutletName("TestOutLetName");
		outlet.setOutletType("TestOutletType");
		
		Outlet outlet1 = new Outlet();
		outlet1.setId(2);
		outlet1.setLastName("TestName1");
		outlet1.setLocation("TestLocation1");
		outlet1.setOutletName("TestOutLetName1");
		outlet1.setOutletType("TestOutletType1");
		
		Outlet outlet2 = new Outlet();
		outlet2.setId(3);
		outlet2.setLastName("TestName");
		outlet2.setLocation("");
		outlet2.setOutletType("TestOutletType");

		
		outletsTestUnique.add(outlet);
		outletsTestUnique.add(outlet1);
		
		
		outletsTestNotNull.add(outlet);
		outletsTestNotNull.add(outlet2);

	}
	/*@Test
	void contextLoads() {
	}*/
	
	@Test
	public void uploadUnique() {
		when(outletService.uploadOutletDetails(outletsTestUnique)).thenReturn(outletsTestUnique);
		
		List<Outlet> uploadOutletDetails = outletService.uploadOutletDetails(outletsTestUnique);
		assertThat(uploadOutletDetails.size()).isEqualTo(2);
	}
	
	@Test
	public void checkNull() {
		when(outletService.uploadOutletDetails(outletsTestNotNull)).thenThrow(TransactionSystemException.class);
		assertThrows(TransactionSystemException.class, () -> {
			outletService.uploadOutletDetails(outletsTestNotNull);
	    });
	}
	
}
