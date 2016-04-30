package com.seavus.dataaccess;

import com.seavus.domain.Member;
import com.seavus.domain.Membership;

public interface MembershipRepository {
	public void save(Member member, Membership membership);
	public Member findMember(Long id);
}
