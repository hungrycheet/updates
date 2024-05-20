import { ActionReducerMap, MetaReducer } from '@ngrx/store';
import * as adjustmentMapperRef from '../../components/gaurantee-container/store/reducers/adjustment-mapper.reducer';
import * as adjustmentConfigRef from '../../components/gaurantee-container/store/reducers/adjustments-config.reducer';
import * as adjustmentInfoRef from '../../components/gaurantee-container/store/reducers/adjustments-info.reducer';
import * as statusReducerRef from '../../components/gaurantee-container/store/reducers/color-config.reducer';
import * as PilotInfoReducerRef from '../../components/gaurantee-container/store/reducers/pilot-info.reducer';
import * as PilotSearchCriteriaReducerRef from '../../components/gaurantee-container/store/reducers/pilot-search-filter.reducer';
import * as ratesReducerRef from '../../components/gaurantee-container/store/reducers/rates.reducer';
import * as BaseBidPeriodReducerRef from './base-bid-period.reducers';
import * as BidPeriodReducerRef from './bid-period.reducers';
import * as BglRlgReducerRef from './blg-rlg.reducer';
import * as PayGuaranteeReducer from './pay-guarantee.reducers';
import * as PayReviewDragReducerRef from './pay-review-drag.reducers';
import * as PayReviewReducerRef from './pay-review.reducers';
import * as PaySummaryReducerRef from './pay-summary.reducers';
import * as PayAuditReducerRef from './pay-audit.reducers';
import * as PayAuditSearchCriteriaReducerRef from'./pay-audit-search-filter.reducers';
import * as PayAuditSearchFiltersReducerRef from'./pay-audit-search-criteria-filters.reducers';
import * as LayoutUserPrefernceReducerRef from './user-layout-preference.reducers';
import * as UserFilterPreferenceReducer from './user-preference.reducers';
import * as BlgFlagReducerRef from './../../components/gaurantee-container/store/reducers/adjustments-blg-flag.reducer';
import * as UpdateCountReducerRef from './update-count.reducer';
import * as UpdateRouterReducerRef from './routerlink.reducers';


export const crewpayFeatureKey = 'crew-pay';

export interface CrewPayState {
  readonly payGuranteePilotDetails: PayGuaranteeReducer.State
  readonly userFilterPreferenceDetails: UserFilterPreferenceReducer.State
  readonly PayAuditSearchCriteriaReducer: PayAuditSearchCriteriaReducerRef.State
  readonly PayAuditSearchFiltersReducer: PayAuditSearchFiltersReducerRef.State
  readonly payGuranteePayReview: PayReviewReducerRef.State
  readonly PaySummaryReducer: PaySummaryReducerRef.State
  readonly PayAuditDataReducer: PayAuditReducerRef.State
  readonly BidPeriodReducer: BidPeriodReducerRef.State
  readonly BlglRlgReducer: BglRlgReducerRef.State
  readonly PayReviewDragReducer: PayReviewDragReducerRef.State
  readonly LayoutUserPrefernceReducer: LayoutUserPrefernceReducerRef.State
  readonly BaseBidPeriodReducer: BaseBidPeriodReducerRef.State
  /** new store */
  readonly PilotSearchCriteriaReducer: PilotSearchCriteriaReducerRef.State
  readonly PilotInfoRecuder: PilotInfoReducerRef.State
  readonly statusReducer: statusReducerRef.StatusState
  readonly ratesReducer: ratesReducerRef.Rate
  readonly adjustmentMapperReducer: adjustmentMapperRef.AdjustmentMapper
  readonly adjustmentInfoReducer: adjustmentInfoRef.AdjustmentInfo
  readonly adjustmentConfigReducer: adjustmentConfigRef.ManualAdjustmentConfigState
  readonly BlgFlagReducer: BlgFlagReducerRef.BlgState
  readonly SocketMessageCountReducer: UpdateCountReducerRef.State;
  readonly RouterLinkReducer:UpdateRouterReducerRef.State;
}

export const reducers: ActionReducerMap<CrewPayState> = {
  payGuranteePilotDetails: PayGuaranteeReducer.PayGuaranteeReducer,
  userFilterPreferenceDetails: UserFilterPreferenceReducer.FilterUserPrefernceReducer,
  PayAuditSearchCriteriaReducer: PayAuditSearchCriteriaReducerRef.payAuditSearchCriteriaReducer,
  PayAuditSearchFiltersReducer: PayAuditSearchFiltersReducerRef.payAuditSearchFiltersReducer,
  payGuranteePayReview: PayReviewReducerRef.PayReviewReducer,
  PaySummaryReducer: PaySummaryReducerRef.PaySummaryReducer,
  PayAuditDataReducer: PayAuditReducerRef.PayAuditReducer,
  BidPeriodReducer: BidPeriodReducerRef.BidPeriodReducer,
  BlglRlgReducer: BglRlgReducerRef.BlglRlgReducer,
  PayReviewDragReducer: PayReviewDragReducerRef.PayReviewDragReducer,
  LayoutUserPrefernceReducer: LayoutUserPrefernceReducerRef.LayoutUserPrefernceReducer,
  BaseBidPeriodReducer: BaseBidPeriodReducerRef.BaseBidPeriodReducer,
  /** new store */
  PilotSearchCriteriaReducer: PilotSearchCriteriaReducerRef.pilotSearchCriteriaReducer,
  PilotInfoRecuder: PilotInfoReducerRef.pilotInfoReducer,
  statusReducer: statusReducerRef.statusReducer,
  ratesReducer: ratesReducerRef.ratesReducer,
  adjustmentMapperReducer: adjustmentMapperRef.adjustmentMappingReducer,
  adjustmentInfoReducer: adjustmentInfoRef.adjustmentInfoReducer,
  adjustmentConfigReducer: adjustmentConfigRef.manualAdjustmentConfigReducer,
  BlgFlagReducer: BlgFlagReducerRef.blgReducer,
  SocketMessageCountReducer: UpdateCountReducerRef.UpdateCountReducer,
  RouterLinkReducer: UpdateRouterReducerRef.UpdateRouterReducer
};


export const metaReducers: MetaReducer<CrewPayState>[] = [];
