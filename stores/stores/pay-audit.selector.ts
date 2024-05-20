import { createSelector } from '@ngrx/store';
import { crewPayFeature } from './crew-pay-feature.selector';

export const payAuditSelector = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.payAuditData
);

export const payAuditSelectorWithFilter = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.payAuditDataWithFilters
);


export const payAuditLoadingStatusSelector = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.isLoading
);

export const payAuditLoadingStatusSelectorWithFilters = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.isLoadingWithFilters
);


export const hasPayAuditSearchedSelector = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.searched
);

export const hasPayAuditSearchedSelectorWithFilters = createSelector(
  crewPayFeature,
  (state: any) => state.PayAuditDataReducer.searchedWithFilters
);
